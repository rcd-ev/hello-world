package com.rc.core.service.impl;

import com.google.gson.Gson;
import com.rc.core.domain.Stat;
import com.rc.core.service.ApiDataService;
import com.rc.core.service.LiveStatsData;
import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;
import com.rc.pool.domain.PoolData;
import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolHashrateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LiveStatsDataImpl implements LiveStatsData {

	private final ApiDataService apiDataService;
	private final NetworkSnapshotService networkSnapshotService;
	private final PoolDataService poolDataService;
	private final PoolHashrateService poolHashrateService;

	@Value("${configs.pools.hashrateURL}")
	private String hashrateURL;

	@Value("${configs.timezone.zone}")
	private String zone;

	@Override
	public void fill() {
		List<PoolData> active = poolDataService.listActivePool();

		NetworkSnapshot snapshot = new NetworkSnapshot();
		List<PoolHashrate> poolHashrates = new ArrayList<>();

		for (int i=0; i<active.size();i++) {
			PoolHashrate pool = new PoolHashrate();
			pool.setPoolData(active.get(i));
			pool.setCreated(new Timestamp(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone)).toInstant().toEpochMilli()));
			pool.setHashrate(fromJson(apiDataService.takeGet(active.get(i).getUrl())).getPool().getHashrate());
			pool.setNetwork(snapshot);
			poolHashrates.add(pool);
		}

		snapshot.setHashrate(Double.parseDouble(apiDataService.takeGet(hashrateURL)));
		snapshot.setCreated(new Timestamp(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(zone)).toInstant().toEpochMilli()));
		snapshot.setPools(poolHashrates);

		networkSnapshotService.create(snapshot);
	}

	private Stat fromJson(String json) {
		return new Gson().fromJson(json, Stat.class);
	}

}

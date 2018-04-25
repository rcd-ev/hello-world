package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsData;
import com.rc.core.service.LiveStatsService;
import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkService;
import com.rc.general.service.NetworksService;
import com.rc.pool.domain.PoolData;
import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolHashrateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LiveStatsServiceImpl implements LiveStatsService {
	private final NetworkService networkService;
	private final LiveStatsData liveStatsData;
	private final PoolDataService poolService;
	private final NetworksService networkTrtlService;
	private final PoolHashrateService poolsTrtlService;
	private final PoolDataService poolTrtlService;


	@Override
	public void saveInformation() {
//		TrtlNetwork network = liveStatsData.fill();

//		test();
//		networkService.create(network);
	}

	private void test() {
		LocalDateTime now = LocalDateTime.now();
		NetworkSnapshot networkTrtl = new NetworkSnapshot();
		List<PoolHashrate> pools = new ArrayList<>();

		PoolData pp = new PoolData();
		pp.setName("fc");
		pp.setUrl("ss");
		pp.setEnable(true);
		//pp.setPools(pools);
		//poolTrtlService.create(pp);


		PoolData p1 = poolService.getByName("eu.turtlepool.space");


		PoolHashrate op = new PoolHashrate();
		op.setHashrate(2.1);
		op.setPoolData(p1);
		op.setNetwork(networkTrtl);
		//poolsTrtlService.create(op);

		PoolHashrate op1 = new PoolHashrate();
		op1.setHashrate(3.1);
		op1.setPoolData(pp);
		op1.setNetwork(networkTrtl);

//		poolsTrtlService.create(op1);

//		pools.add(op);

//		List<PoolsTrtl> pools = new ArrayList<>();
		pools.add(op);
		pools.add(op1);


//		List<PoolsTrtl> poolss = new ArrayList<>();


//		networkTrtl.setDifficulty(1.2);
//		networkTrtl.setHeight(3.0);
		networkTrtl.setCreated(new Timestamp(ZonedDateTime.of(now, ZoneId.of("Europe/Warsaw")).toInstant().toEpochMilli()));
		networkTrtl.setPools(pools);
		networkTrtlService.create(networkTrtl);

	}

}

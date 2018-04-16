package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsData;
import com.rc.core.service.LiveStatsService;
import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiveStatsServiceImpl implements LiveStatsService {
	private final NetworkService networkService;
	private final LiveStatsData liveStatsData;

	@Override
	public void saveInformation() {
//		TrtlNetwork network = liveStatsData.fill();
//		networkService.create(network);
	}

}

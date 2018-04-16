package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LiveStatsScheduler {
	private final LiveStatsService liveStatsService;

	@Scheduled(fixedRate = 5000) //todo set parameter in properties
	public void liveStat() {
		//save data with endpoints to pool and general in rate 5s
		liveStatsService.saveInformation();
	}
}

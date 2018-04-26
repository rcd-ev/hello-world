package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LiveStatsScheduler {
	private final LiveStatsService liveStatsService;
	private final LiveStatsDataImpl liveStatsData;

	@Scheduled(fixedRateString = "${configs.scheduler.rate}")
	public void liveStats() {
		liveStatsData.fill();
	}

}

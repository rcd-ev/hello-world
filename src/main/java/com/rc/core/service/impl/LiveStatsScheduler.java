package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LiveStatsScheduler {
	private final LiveStatsService liveStatsService;

//	@Value("${configs.scheduler.rate}")
//	private long rate;

	@Scheduled(fixedRate = 5000)
	public void liveStat() {
		liveStatsService.saveInformation();
	}
}

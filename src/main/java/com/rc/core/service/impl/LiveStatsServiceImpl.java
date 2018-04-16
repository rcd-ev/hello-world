package com.rc.core.service.impl;

import com.rc.core.service.LiveStatsService;
import com.rc.general.domain.General;
import com.rc.general.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiveStatsServiceImpl implements LiveStatsService {
	private final GeneralService generalService;

	@Override
	public void saveInformation() {

		General general = new General();

		generalService.create(general);
	}

}

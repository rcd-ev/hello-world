package com.rc.general.service.impl;

import com.rc.core.service.ApiDataService;
import com.rc.general.dao.TrtlGeneralDao;
import com.rc.general.domain.TrtlGeneral;
import com.rc.general.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements GeneralService {
	private final TrtlGeneralDao generalDao;
	private final ApiDataService apiDataService;

	private final String hashrateURL = "https://turtle-coin.com/q/hashrate/";
	private final String heightURL = "https://turtle-coin.com/q/height/";

	@Override
	public Page<TrtlGeneral> listAllByPage(Pageable pageable) {
		return generalDao.findAll(pageable);
	}

	@Override
	public List<TrtlGeneral> findAllGenerals() {
		return generalDao.findAll();
	}

	@Override
	public String takeHashrate() {
		return apiDataService.takeGet(hashrateURL);
	}

	@Override
	public String takeHeight() {
		return apiDataService.takeGet(heightURL);
	}

	@Override
	@Transactional
	public void create(TrtlGeneral general) {
		generalDao.save(general);
	}

}

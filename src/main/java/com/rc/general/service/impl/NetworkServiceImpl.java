package com.rc.general.service.impl;

import com.rc.general.dao.TrtlNetworkDao;
import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NetworkServiceImpl implements NetworkService {
	private final TrtlNetworkDao networkDao;

	@Override
	@Transactional
	public void create(TrtlNetwork network) {
		networkDao.save(network);
	}

	@Override
	public Optional<TrtlNetwork> getById(Long id) {
		return networkDao.findById(id);
	}

	@Override
	public List<TrtlNetwork> findAllNetworks() {
		return networkDao.findAll();
	}

}

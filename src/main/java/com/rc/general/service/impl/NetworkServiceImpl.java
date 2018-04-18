package com.rc.general.service.impl;

import com.rc.general.dao.TrtlNetworkDao;
import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public TrtlNetwork getNetworkById(Long id) {
		return networkDao.getOne(id);
	}

	@Override
	public List<TrtlNetwork> findAllNetworks() {
		return networkDao.findAll();
	}

	@Override
	public Page<TrtlNetwork> listAllByPage(Pageable pageable) {
		return networkDao.findAll(pageable);
	}

	@Override
	public Page<TrtlNetwork> listDescAllByPage() {
		Pageable pageable = new PageRequest(0, 20, Sort.Direction.DESC,"id");
		Page<TrtlNetwork> bottomPage = networkDao.findAll(pageable);
		return bottomPage;
	}

}

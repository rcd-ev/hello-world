package com.rc.pool.service.impl;

import com.rc.pool.dao.PoolDataDao;
import com.rc.pool.domain.PoolData;
import com.rc.pool.service.PoolDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PoolDataServiceImpl implements PoolDataService {
	private final PoolDataDao poolDao;

	@Override
	@Transactional
	public void create(PoolData pool) {
		poolDao.save(pool);
	}

	@Override
	public Optional<PoolData> getById(Long id) {
		return poolDao.findById(id);
	}

	@Override
	public Optional<PoolData> getByNameOptional(String name) {
		return poolDao.findByNameOptional(name);
	}

	@Override
	public PoolData getByName(String name) {
		return poolDao.findByName(name);
	}

	@Override
	public Page<PoolData> listAll(Pageable pageable) {
		return poolDao.findAll(pageable);
	}
}

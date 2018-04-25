package com.rc.pool.service.impl;

import com.rc.pool.dao.PoolHashrateDao;
import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.service.PoolHashrateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PoolHashrateServiceImpl implements PoolHashrateService {
	private final PoolHashrateDao poolDao;

	@Override
	public void create(PoolHashrate pool) {
		poolDao.save(pool);
	}

	@Override
	public Optional<PoolHashrate> getById(Long id) {
		return poolDao.findById(id);
	}

	@Override
	public Page<PoolHashrate> listAllByPage(Pageable pageable) {
		return poolDao.findAll(pageable);
	}
}

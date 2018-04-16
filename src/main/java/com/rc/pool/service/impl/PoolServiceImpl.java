package com.rc.pool.service.impl;

import com.rc.pool.dao.PoolDao;
import com.rc.pool.domain.Pool;
import com.rc.pool.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PoolServiceImpl implements PoolService {
	private final PoolDao poolDao;

	@Override
	@Transactional
	public void create(Pool pool) {
		poolDao.save(pool);
	}

	@Override
	public Optional<Pool> getById(Long id) {
		return poolDao.findById(id);
	}

	@Override
	public Page<Pool> listAllByPage(Pageable pageable) {
		return poolDao.findAll(pageable);
	}
}

package com.rc.pool.service.impl;

import com.rc.pool.dao.TrtlPoolDao;
import com.rc.pool.domain.TrtlPool;
import com.rc.pool.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PoolServiceImpl implements PoolService {
	private final TrtlPoolDao poolDao;

	@Override
	@Transactional
	public void create(TrtlPool pool) {
		poolDao.save(pool);
	}

	@Override
	public Optional<TrtlPool> getById(Long id) {
		return poolDao.findById(id);
	}

	@Override
	public Page<TrtlPool> listAllByPage(Pageable pageable) {
		return poolDao.findAll(pageable);
	}

	@Override public List<TrtlPool> getAllPools() {
		return poolDao.findAll();
	}
}

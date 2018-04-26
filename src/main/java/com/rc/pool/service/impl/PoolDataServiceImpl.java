package com.rc.pool.service.impl;

import com.rc.pool.dao.PoolDataDao;
import com.rc.pool.domain.PoolData;
import com.rc.pool.service.PoolDataService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.ResourceAccessException;

@Service
@RequiredArgsConstructor
public class PoolDataServiceImpl implements PoolDataService {
	private final PoolDataDao poolDao;

	@Override
	@Transactional
	public PoolData createPoolData(PoolData pool) {
		return poolDao.save(pool);
	}

	@Override
	public PoolData updatePoolData(PoolData pool, Long id) {
		PoolData data = poolDao.findById(id).orElseThrow(()-> new NullPointerException("Pool not found"));
		data.setEnable(pool.getEnable());
		data.setName(pool.getName());
		data.setUrl(pool.getUrl());
		return poolDao.save(data);
	}

	@Override
	public PoolData activePoolData(PoolData pool, Long id) {
		PoolData data = poolDao.findById(id).orElseThrow(()-> new NullPointerException("Pool not found"));
		data.setEnable(pool.getEnable());
		return poolDao.save(data);
	}

	@Override
	@Transactional
	public void create(PoolData pool) {
		poolDao.save(pool);
	}

	@Override
	public void deletePoolData(Long id) {
		poolDao.deleteById(id);
	}

	@Override
	public PoolData getById(Long id) {
		return poolDao.getOne(id);
	}

	@Override
	public Optional<PoolData> getByNameOptional(String name) {
		return poolDao.findByNameOptional(name);
	}

	@Override
	public List<PoolData> findAllPoolData() {
		return poolDao.findAll();
	}

	@Override
	public PoolData getByName(String name) {
		return poolDao.findByName(name);
	}

	@Override
	public Page<PoolData> listAll(Pageable pageable) {
		return poolDao.findAll(pageable);
	}

	@Override
	public List<PoolData> listActivePool() {
		return poolDao.findByActiveEnable();
	}

}

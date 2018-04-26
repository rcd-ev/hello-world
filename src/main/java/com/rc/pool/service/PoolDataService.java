package com.rc.pool.service;

import com.rc.pool.domain.PoolData;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PoolDataService {
	void create(PoolData pool);
	void deletePoolData(Long id);
	PoolData createPoolData(PoolData pool);
	PoolData updatePoolData(PoolData pool, Long id);
	PoolData activePoolData(PoolData pool, Long id);
	PoolData getById(Long id);
	PoolData getByName(String name);
	Optional<PoolData> getByNameOptional(String name);
	List<PoolData> findAllPoolData();
	Page<PoolData> listAll(Pageable pageable);
	List<PoolData> listActivePool();
}

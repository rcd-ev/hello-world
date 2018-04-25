package com.rc.pool.service;

import com.rc.pool.domain.PoolData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PoolDataService {
	void create(PoolData pool);
	Optional<PoolData> getById(Long id);
	PoolData getByName(String name);
	Optional<PoolData> getByNameOptional(String name);
	Page<PoolData> listAll(Pageable pageable);
}

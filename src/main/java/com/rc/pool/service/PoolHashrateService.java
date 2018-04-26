package com.rc.pool.service;

import com.rc.pool.domain.PoolHashrate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PoolHashrateService {
	void create(PoolHashrate pool);
	Optional<PoolHashrate> getById(Long id);
	Page<PoolHashrate> listAllByPage(Pageable pageable);
}

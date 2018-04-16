package com.rc.pool.service;

import com.rc.pool.domain.Pool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PoolService {
	void create(Pool pool);
	Optional<Pool> getById(Long id);
	Page<Pool> listAllByPage(Pageable pageable);
}

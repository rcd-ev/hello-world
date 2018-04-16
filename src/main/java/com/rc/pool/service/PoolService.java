package com.rc.pool.service;

import com.rc.pool.domain.TrtlPool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PoolService {
	void create(TrtlPool pool);
	Optional<TrtlPool> getById(Long id);
	Page<TrtlPool> listAllByPage(Pageable pageable);
	List<TrtlPool> getAllPools();
}

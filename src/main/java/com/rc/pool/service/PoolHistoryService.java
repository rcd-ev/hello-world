package com.rc.pool.service;

import com.rc.pool.domain.PoolHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoolHistoryService {
	Page<PoolHistory> listAllByPage(Pageable pageable);
}

package com.rc.pool.service.impl;

import com.rc.pool.dao.PoolHistoryDao;
import com.rc.pool.domain.PoolHistory;
import com.rc.pool.service.PoolHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoolHistoryServiceImpl implements PoolHistoryService {
	private final PoolHistoryDao poolHistoryDao;

	@Override
	public Page<PoolHistory> listAllByPage(Pageable pageable) {
		return poolHistoryDao.findAll(pageable);
	}
}

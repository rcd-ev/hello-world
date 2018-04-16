package com.rc.pool.endpoint;

import com.rc.pool.domain.Pool;
import com.rc.pool.domain.PoolHistory;
import com.rc.pool.service.PoolHistoryService;
import com.rc.pool.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PoolRestController {
	private final PoolService poolService;
	private final PoolHistoryService poolHistoryService;

	@RequestMapping(value = "/pools", method = RequestMethod.GET)
	Page<Pool> listOfPools(Pageable pageable) {
		return poolService.listAllByPage(pageable);
	}

	@RequestMapping(value = "/poolsHistory", method = RequestMethod.GET)
	Page<PoolHistory> listOfHistoryPools(Pageable pageable) {
		return poolHistoryService.listAllByPage(pageable);
	}

}

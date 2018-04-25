package com.rc.pool.endpoint;

import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pool")
@RequiredArgsConstructor
public class PoolRestController {

	private final PoolService poolService;
	private final PoolDataService pool;

}

package com.rc.pool.endpoint;

import com.rc.pool.domain.TrtlPool;
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

	@RequestMapping(value = "/pools", method = RequestMethod.GET)
	Page<TrtlPool> listOfPools(Pageable pageable) {
		return poolService.listAllByPage(pageable);
	}

}

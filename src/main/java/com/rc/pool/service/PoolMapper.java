package com.rc.pool.service;

import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.dto.PoolDto;

import java.util.List;

public interface PoolMapper {
	List<PoolDto> mapDto(List<PoolHashrate> entity);
}

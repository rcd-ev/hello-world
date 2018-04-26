package com.rc.pool.service.impl;

import com.rc.pool.domain.PoolHashrate;
import com.rc.pool.dto.PoolDto;
import com.rc.pool.service.PoolMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PoolMapperImpl implements PoolMapper {
	@Override
	public List<PoolDto> mapDto(List<PoolHashrate> entity) {
		List<PoolDto> dtos = new ArrayList<PoolDto>();

		for(PoolHashrate dto:entity) {
			PoolDto poolDto = new PoolDto();
			poolDto.setHashrate(dto.getHashrate());
			poolDto.setName(dto.getPoolData().getName());
			dtos.add(poolDto);
		}

		return dtos;
	}

}

package com.rc.general.dto;

import com.rc.pool.dto.PoolHashrateDto;

import java.util.List;

import lombok.Data;

@Data
public class NetworkSnapshotDto {
	private String create;
	private double hashrate;
	private List<PoolHashrateDto> pools;
}

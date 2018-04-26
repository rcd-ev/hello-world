package com.rc.pool.dto;

import com.rc.general.dto.NetworkSnapshotDto;

import lombok.Data;

@Data
public class PoolHashrateDto {
	private Long id;
	private double hashrate;
	private String created;
	private NetworkSnapshotDto network;
	private PoolDataDto poolData;
}

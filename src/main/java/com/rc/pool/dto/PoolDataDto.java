package com.rc.pool.dto;

import lombok.Data;

@Data
public class PoolDataDto {
	private Long id;
	private String name;
	private String url;
	private boolean enable;
	private String created;
}

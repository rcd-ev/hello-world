package com.rc.pool.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PoolDto {
	@NotEmpty
	private String name;
	@NotEmpty
	private String region;
}

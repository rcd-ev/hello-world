package com.rc.general.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class GeneralDto {
	@NotEmpty
	private String hashrate;
	@NotEmpty
	private String height;
	@NotEmpty
	private String difficulty;
	@NotEmpty
	private String created;
}

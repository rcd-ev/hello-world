package com.rc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Charts {
	List<List<Long>> hashrate;
	List<List<Long>> workers;
	List<List<Long>> difficulty;
}

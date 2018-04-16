package com.rc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Charts {
	List<List<String>> hashrate;
	List<List<String>> workers;
	List<List<String>> difficulty;
}

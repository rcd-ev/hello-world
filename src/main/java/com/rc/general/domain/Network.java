package com.rc.general.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Network {
	String difficulty;
	String height;
	String timestamp;
	String reward;
	String hash;
	//  Long difficulty;
	//	Long height;
	//	Long timestamp;
	//	Long reward;
}

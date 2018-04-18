package com.rc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config {
	List<Port> ports;
	Long hashrateWindow;
	Double fee;
	String coin;
	Double coinUnits;
	Double coinDifficultyTarget;
	String symbol;
	Long depth;
	Donation donation;	//empty object
	String version;
	Long minPaymentThreshold;
	Long denominationUnit;
	Long blockTime;
	boolean slushMiningEnabled;
	Double weight;
}

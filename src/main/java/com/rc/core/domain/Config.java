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
	String hashrateWindow;
	String fee;
	String coin;
	String coinUnits;
	String coinDifficultyTarget;
	String symbol;
	String depth;
	Donation donation;	//empty object
	String version;
	String minPaymentThreshold;
	String denominationUnit;
	String blockTime;
	boolean slushMiningEnabled;
	String weight;
}

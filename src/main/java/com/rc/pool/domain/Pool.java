package com.rc.pool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pool {
	PoolStats stats;
	String[] blocks;
	String totalBlocks;
	String[] payments;
	String totalPayments;
	String totalMinersPaid;
	String miners;
	String hashrate;
	String roundHashes;
	String lastBlockFound;
}

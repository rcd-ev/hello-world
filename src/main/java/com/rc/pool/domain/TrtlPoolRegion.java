package com.rc.pool.domain;

import lombok.Getter;

public enum TrtlPoolRegion {
	EUTS("eu.turtlepool.space"),
	ATPOOL("turtle.atpool.party"),
	MINE2G("trtl.mine2gether.com"),
	TNINJA("trtl.ninja"),
	ZPOOL("z-pool.com"),
	HKTS("hk.turtlepool.space"),
	USTS("us.turtlepool.space"),
	NYMINE("ny.minetrtl.us"),
	INPOOL("auspool.turtleco.in");

	@Getter
	private final String pool;

	TrtlPoolRegion(String pool) {
		this.pool = pool;
	}

}

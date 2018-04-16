package com.rc.core.domain;

import com.rc.general.domain.Network;
import com.rc.pool.domain.Pool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrtlData {
	Config config;
	Pool pool;
	Charts charts;
	Network network;
}

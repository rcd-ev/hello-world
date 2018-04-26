package com.rc.core.service;

import com.rc.general.domain.NetworkSnapshot;
import com.rc.pool.domain.PoolData;
import com.rc.pool.domain.PoolHashrate;

import java.util.List;

public interface LiveStatsService {
	void saveData();
	void dataProcessing();
	void callPool(PoolData active, List<PoolHashrate> poolHashrates, NetworkSnapshot snapshot);
	void callNetwork(NetworkSnapshot snapshot);
}

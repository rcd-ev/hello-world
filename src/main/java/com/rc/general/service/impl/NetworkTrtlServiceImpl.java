package com.rc.general.service.impl;

import com.rc.general.dao.NetworkSnapshotDao;
import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NetworkTrtlServiceImpl implements NetworksService {
	private final NetworkSnapshotDao networkDao;

	@Override
	@Transactional
	public void create(NetworkSnapshot network) {
		networkDao.save(network);
	}

}

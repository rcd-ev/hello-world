package com.rc.general.service.impl;

import com.rc.general.dao.NetworkSnapshotDao;
import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NetworkSnapshotServiceImpl implements NetworkSnapshotService {
	private final NetworkSnapshotDao networkDao;

	@Override
	@Transactional
	public void create(NetworkSnapshot network) {
		networkDao.save(network);
	}

	@Override
	public Optional<NetworkSnapshot> getById(Long id) {
		return networkDao.findById(id);
	}

	@Override public NetworkSnapshot getNetworkById(Long id) {
		return networkDao.getOne(id);
	}

	@Override
	public List<NetworkSnapshot> findAllNetworks() {
		return networkDao.findAll();
	}

	@Override
	public Page<NetworkSnapshot> findAllNetworksByPage(Pageable pageable) {
		return networkDao.findAll(pageable);
	}

	@Override
	public String parseUri(String str, boolean sort) {
		String result = "";
		String[] query, stored, sorted;
		if (StringUtils.isEmpty(str)) {
			return null;
		} else {
			if (str.contains("&page")) {
				query = str.split("&page");
				result = query[0];
			}
			if (str.contains("?page")) {
				query = str.split("\\?page");
				result = query[0];
			}
			if (result.contains("sort=")) {
				stored = result.split("sort=");
				result = stored[1];
			}
			if (sort) {
				sorted = result.split(",");
				result = sorted[1];
			}
			if (StringUtils.isEmpty(result)) {
				return null;
			}
			return result;
		}
	}

}

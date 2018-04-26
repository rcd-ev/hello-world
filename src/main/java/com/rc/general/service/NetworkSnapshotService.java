package com.rc.general.service;

import com.rc.general.domain.NetworkSnapshot;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NetworkSnapshotService {
	void create(NetworkSnapshot network);
	Optional<NetworkSnapshot> getById(Long id);
	NetworkSnapshot getNetworkById(Long id);
	List<NetworkSnapshot> findAllNetworks();
	Page<NetworkSnapshot> findAllNetworksByPage(Pageable pageable);
	String parseUri(String str, boolean sort);
}

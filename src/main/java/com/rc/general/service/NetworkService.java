package com.rc.general.service;

import com.rc.general.domain.TrtlNetwork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NetworkService {
	void create(TrtlNetwork network);
	Optional<TrtlNetwork> getById(Long id);
	TrtlNetwork getNetworkById(Long id);
	List<TrtlNetwork> findAllNetworks();
	Page<TrtlNetwork> findAllNetworksByPage(Pageable pageable);
	Page<TrtlNetwork> listDescAllByPage();
}

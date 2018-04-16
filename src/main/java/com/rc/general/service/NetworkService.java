package com.rc.general.service;

import com.rc.general.domain.TrtlNetwork;

import java.util.List;
import java.util.Optional;

public interface NetworkService {
	void create(TrtlNetwork network);
	Optional<TrtlNetwork> getById(Long id);
	List<TrtlNetwork> findAllNetworks();
}

package com.rc.general.service.impl;

import com.rc.general.dao.TrtlNetworkDao;
import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NetworkServiceImpl implements NetworkService {
	private final TrtlNetworkDao networkDao;

	@Value("${configs.pagination.page}")
	private int pages;

	@Override
	@Transactional
	public void create(TrtlNetwork network) {
		networkDao.save(network);
	}

	@Override
	public Optional<TrtlNetwork> getById(Long id) {
		return networkDao.findById(id);
	}

	@Override
	public TrtlNetwork getNetworkById(Long id) {
		return networkDao.getOne(id);
	}

	@Override
	public List<TrtlNetwork> findAllNetworks() {
		return networkDao.findAll();
	}

	@Override
	public Page<TrtlNetwork> findAllNetworksByPage(Pageable pageable) {
		return networkDao.findAll(pageable);
	}

	@Override
	public Page<TrtlNetwork> listDescAllByPage() {
		Pageable pageable = new PageRequest(0, pages, Sort.Direction.DESC,"id");
		Page<TrtlNetwork> bottomPage = networkDao.findAll(pageable);
		return bottomPage;
	}

	@Override
	public String parseUri(String str) {
		String result = "";
		String[] query, stored;
		if (StringUtils.isEmpty(str)) {
			return null;
		} else {
			if (str.contains("&page")){
				query = str.split("&page");
				result = query[0];
			}
			if (str.contains("?page")) {
				query = str.split("\\?page");
				result = query[0];
			}
			if (result.contains("sort=")){
				stored = result.split("sort=");
				result = stored[1];
			}
			if (StringUtils.isEmpty(result)) {
				return null;
			}
			return result;
		}
	}

}

package com.rc.general.service;

import com.rc.general.domain.General;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService {
	Page<General> listAllByPage(Pageable pageable);
	String takeHashrate();
	String takeHeight();
	void create(General general);
}

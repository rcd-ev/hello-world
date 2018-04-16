package com.rc.general.service;

import com.rc.general.domain.TrtlGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService {
	String takeHashrate();
	String takeHeight();
	void create(TrtlGeneral general);
	Page<TrtlGeneral> listAllByPage(Pageable pageable);
	List<TrtlGeneral> findAllGenerals();
}

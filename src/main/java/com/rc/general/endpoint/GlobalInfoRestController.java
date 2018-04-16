package com.rc.general.endpoint;

import com.rc.core.service.impl.ApiDataServiceImpl;
import com.rc.general.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GlobalInfoRestController {
	private final GeneralService api;

	@RequestMapping(value = "/hashrate", method = RequestMethod.GET)
	String generalHashrate() {
		return api.takeHashrate();
	}

}

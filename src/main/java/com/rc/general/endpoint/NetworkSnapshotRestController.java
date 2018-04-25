package com.rc.general.endpoint;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/network")
@RequiredArgsConstructor
public class NetworkSnapshotRestController {

	private final GeneralService api;
	private final NetworkService networkService;

	@Value("${configs.pagination.page}")
	private int pageSize;

	@RequestMapping()
	public TrtlNetwork findNetworkById(@RequestParam("id") long id){
		return networkService.getNetworkById(id);
	}

	@RequestMapping(value = "/hashrate", method = RequestMethod.GET)
	public String networkHashrate() {
		return api.takeHashrate();
	}

	@GetMapping
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public Page<TrtlNetwork> lastNetworkList(@RequestParam("p") int page, HttpServletRequest request) {
		Pageable pageable;

		pageable = new PageRequest(page, pageSize, Sort.Direction.DESC,"id");

		return networkService.findAllNetworksByPage(pageable);
	}

}

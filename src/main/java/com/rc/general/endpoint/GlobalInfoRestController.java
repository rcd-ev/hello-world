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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GlobalInfoRestController {
	private final GeneralService api;
	private final NetworkService networkService;

	@Value("${configs.pagination.page}")
	private int pageSize;

	@RequestMapping(value = "/hashrate", method = RequestMethod.GET)
	String generalHashrate() {
		return api.takeHashrate();
	}

	@RequestMapping("/api/network")
	public TrtlNetwork findNetworkById(@RequestParam("id") long id){
		TrtlNetwork networks = networkService.getNetworkById(id);
		return networks;
	}

	@GetMapping
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TrtlNetwork>> listAllNetwork() {
		List<TrtlNetwork> networks = networkService.findAllNetworks();
		if (networks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrtlNetwork>>(networks, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "/api/record", method = RequestMethod.GET)
	public Page<TrtlNetwork> lastNetworkList() {
		Pageable pageable = new PageRequest(0, pageSize, Sort.Direction.DESC,"id");
		Page<TrtlNetwork> bottomPage = networkService.findAllNetworksByPage(pageable);
		return bottomPage;
	}

}

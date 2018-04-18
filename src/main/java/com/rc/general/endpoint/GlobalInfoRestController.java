package com.rc.general.endpoint;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping(value = "/hashrate", method = RequestMethod.GET)
	String generalHashrate() {
		return api.takeHashrate();
	}

	@RequestMapping("/api/network")
	public TrtlNetwork findById(@RequestParam("id") long id){
		TrtlNetwork networks = networkService.getNetworkById(id);
		return networks;
	}

	@GetMapping
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TrtlNetwork>> listAllNet() {
		List<TrtlNetwork> networks = networkService.findAllNetworks();
		if (networks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrtlNetwork>>(networks, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public Page<TrtlNetwork> testList() {
		Pageable pageable = new PageRequest(0, 20, Sort.Direction.DESC,"id");
		Page<TrtlNetwork> bottomPage = networkService.listAllByPage(pageable);
		return bottomPage;
	}

}

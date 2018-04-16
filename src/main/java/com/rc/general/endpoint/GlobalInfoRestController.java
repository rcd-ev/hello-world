package com.rc.general.endpoint;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@GetMapping
	@RequestMapping("/list")
	public ResponseEntity<List<TrtlNetwork>> listAllNet() {
		List<TrtlNetwork> networks = networkService.findAllNetworks();
		if (networks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrtlNetwork>>(networks, HttpStatus.OK);
	}




}

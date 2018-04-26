package com.rc.general.endpoint;

import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/network")
@RequiredArgsConstructor
public class NetworkSnapshotRestController {

	private final NetworkSnapshotService networkSnapshotService;

	@Value("${configs.pagination.page}")
	private int pageSize;

	@GetMapping
	public NetworkSnapshot findNetworkById(@RequestParam("id") long id) {
		NetworkSnapshot networks = networkSnapshotService.getNetworkById(id);
		return networks;
	}

	@RequestMapping(value = "/records", method = RequestMethod.GET)
	public Page<NetworkSnapshot> lastNetworkLists(Pageable pageable) {
		return networkSnapshotService.findAllNetworksByPage(pageable);
	}

	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public Page<NetworkSnapshot> lastNetworkList(@RequestParam("p") int page) {
		Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
		return networkSnapshotService.findAllNetworksByPage(pageable);
	}

}

package com.rc.core.controller;

import com.rc.general.domain.NetworkSnapshot;
import com.rc.general.service.NetworkSnapshotService;
import com.rc.pool.service.PoolDataService;
import com.rc.pool.service.PoolHashrateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	private NetworkSnapshotService networkSnapshotService;

	@Autowired
	private PoolDataService poolDataService;

	@Autowired
	private PoolHashrateService poolHashrateService;

	@Value("${configs.pagination.page}")
	private int pageSize;

	@GetMapping
	@RequestMapping("/")
	public String mainPage(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)})
	@PageableDefault(size = 20) Pageable pageable, Model model, HttpServletRequest request) {

		Page<NetworkSnapshot> pages = networkSnapshotService.findAllNetworksByPage(pageable);
		model.addAttribute("networks", pages.getContent());
		model.addAttribute("page", pages);
		model.addAttribute("url", "/");
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("sort", networkSnapshotService.parseUri(request.getQueryString(), true));
		model.addAttribute("uri", request.getQueryString());
		model.addAttribute("urii", networkSnapshotService.parseUri(request.getQueryString(), false));

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<NetworkSnapshot> getNetworks() {
		return networkSnapshotService.findAllNetworks();
	}

}

package com.rc.core.controller;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import com.rc.pool.service.PoolService;
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
	private NetworkService networkService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private PoolService poolService;

	@Value("${configs.pagination.page}")
	private int pageSize;

	@GetMapping
	@RequestMapping("/")
	public String mainPage(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)})
	@PageableDefault(size = 20) Pageable pageable, Model model, HttpServletRequest request) {
		Page<TrtlNetwork> pages = networkService.findAllNetworksByPage(pageable);

		model.addAttribute("networks", pages.getContent());
		model.addAttribute("page", pages);
		model.addAttribute("url", "/");
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("sort", null);
		model.addAttribute("uri", request.getQueryString());
		model.addAttribute("urii", networkService.parseUri(request.getQueryString()));

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<TrtlNetwork> getNetworks() {
		return networkService.findAllNetworks();
	}

}

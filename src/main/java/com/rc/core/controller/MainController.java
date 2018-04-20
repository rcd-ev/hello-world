package com.rc.core.controller;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import com.rc.pool.service.PoolService;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private NetworkService networkService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private PoolService poolService;

	@Value("${configs.pagination.page}")
	private int paginationPage;

	@GetMapping
	@RequestMapping("/")
	public String mainPage(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)})
	@PageableDefault(size = 20) Pageable pageable, Model model) {

		Page<TrtlNetwork> pages = networkService.findAllNetworksByPage(pageable);

		model.addAttribute("networks", pages.getContent());
		model.addAttribute("page", pages);
		model.addAttribute("url", "/");
		model.addAttribute("first", pages.isFirst());
		model.addAttribute("last", pages.isLast());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("asc", pages.getSort().ascending());
		model.addAttribute("desc", pages.getSort().descending());
		model.addAttribute("isSorted", pages.getSort().isSorted());
		model.addAttribute("as_id", pages.getSort().ascending().getOrderFor("id"));
		model.addAttribute("ds_id", pages.getSort().descending().getOrderFor("id"));
		model.addAttribute("as_time", pages.getSort().ascending().getOrderFor("created"));
		model.addAttribute("ds_time", pages.getSort().descending().getOrderFor("created"));
		model.addAttribute("as_hashrate", pages.getSort().ascending().getOrderFor("generalNetwork.hashrate"));
		model.addAttribute("ds_hashrate", pages.getSort().descending().getOrderFor("generalNetwork.hashrate"));

		return "home";
	}

	@GetMapping
	@RequestMapping("/test")
	public String mainP(@SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)})
	@PageableDefault(size = 20)Pageable pageable, Model model) {


		Page<TrtlNetwork> pages = networkService.findAllNetworksByPage(pageable);


		model.addAttribute("url", "/test");
		model.addAttribute("networks", pages.getContent());
		model.addAttribute("page", pages);
		model.addAttribute("first", pages.isFirst());
		model.addAttribute("last", pages.isLast());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("asc", pages.getSort().ascending());
		model.addAttribute("desc", pages.getSort().descending());


		model.addAttribute("isSorted", pages.getSort().isSorted());
		model.addAttribute("as_id", pages.getSort().ascending().getOrderFor("id"));
		model.addAttribute("ds_id", pages.getSort().descending().getOrderFor("id"));
		model.addAttribute("as_time", pages.getSort().ascending().getOrderFor("created"));
		model.addAttribute("ds_time", pages.getSort().descending().getOrderFor("created"));
		model.addAttribute("as_hashrate", pages.getSort().ascending().getOrderFor("generalNetwork.hashrate"));
		model.addAttribute("ds_hashrate", pages.getSort().descending().getOrderFor("generalNetwork.hashrate"));

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<TrtlNetwork> getNetworks() {
		return networkService.findAllNetworks();
	}

}

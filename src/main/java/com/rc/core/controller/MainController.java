package com.rc.core.controller;

import com.rc.general.domain.TrtlNetwork;
import com.rc.general.service.GeneralService;
import com.rc.general.service.NetworkService;
import com.rc.pool.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@GetMapping
	@RequestMapping("/")
	public String mainPage(Model model) {
//		model.addAttribute("networks", networkService.findAllNetworks());
		model.addAttribute("networks", networkService.listDescAllByPage());
		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<TrtlNetwork> getNetworks() {
		return networkService.findAllNetworks();
	}

}

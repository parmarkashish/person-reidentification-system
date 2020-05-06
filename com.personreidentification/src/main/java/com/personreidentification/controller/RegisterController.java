package com.personreidentification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.CityVO;
import com.personreidentification.model.CountryVO;
import com.personreidentification.model.LoginVO;
import com.personreidentification.model.RegisterVO;
import com.personreidentification.model.StateVO;
import com.personreidentification.service.CityService;
import com.personreidentification.service.CountryService;
import com.personreidentification.service.LoginService;
import com.personreidentification.service.RegisterService;
import com.personreidentification.service.StateService;
import com.personreidentification.utils.BaseMethod;

@Controller
public class RegisterController {
	
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	@Autowired
	CityService cityService;
	@Autowired
	LoginService loginService;
	@Autowired
	RegisterService registerService;
	
	@GetMapping(value = "/loadRegister")
	public ModelAndView loadRegister(Model model) {
		model.addAttribute("registerVO",new RegisterVO());
		List<CountryVO> countryList=countryService.countrySearch();
		List<StateVO> stateList=stateService.stateSearch();
		List<CityVO> cityList=cityService.citySearch();
		model.addAttribute("countryList", countryList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityList", cityList);
		return new ModelAndView("/register");
	}	
	
	@PostMapping(value="/addClient")
	public ModelAndView addClient(@ModelAttribute RegisterVO registerVO){
		String password = BaseMethod.generatePassword();
		
		LoginVO loginVO=new LoginVO();
		loginVO.setEnabled("1");
		loginVO.setPassword(password);
		loginVO.setRole("ROLE_CLIENT");
		loginVO.setStatus(true);
		loginVO.setUsername(registerVO.getEmail());
		loginService.loginInsert(loginVO);
		
		registerVO.setLoginVO(loginVO);
		registerVO.setPassword(password);
		registerService.registerInsert(registerVO);
		BaseMethod.sendMail(registerVO.getLoginVO().getUsername(), password,registerVO.getOwnerName());
		
		
		System.out.println("hi");
		return new ModelAndView("/login");
		
	}
	

}

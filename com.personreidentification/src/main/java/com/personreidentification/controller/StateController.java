package com.personreidentification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.CountryVO;
import com.personreidentification.model.StateVO;
import com.personreidentification.service.CountryService;
import com.personreidentification.service.StateService;

@Controller
public class StateController {
	
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping(value = "/admin/loadState")
	public ModelAndView loadState(Model model){			
		List<CountryVO> countryList=countryService.countrySearch();
		model.addAttribute("countryList", countryList);
		model.addAttribute("stateVO", new StateVO());
		return new ModelAndView("/admin/addState");
	}
	
	@PostMapping(value = "/admin/addState")
	public ModelAndView addState(@ModelAttribute StateVO stateVO){		
		stateVO.setStateStatus(true);
		stateService.stateInsert(stateVO);		
		return new ModelAndView("redirect:/admin/loadState");
	}
	
	@GetMapping(value = "/admin/viewState")
	public ModelAndView viewStateToAdmin(Model model) {		
		List<StateVO> stateList=stateService.stateSearch();	
		model.addAttribute("stateList", stateList);
		return new ModelAndView("/admin/viewState");
	}
	
	@GetMapping(value = "/admin/editState")
	public ModelAndView editState(@RequestParam int id,Model model) {		
		StateVO stateVO=new StateVO();
		stateVO.setId(id);
		stateVO=stateService.stateSearchById(stateVO);
		List<CountryVO> countryList=countryService.countrySearch();
		model.addAttribute("countryList", countryList);
		model.addAttribute("stateVO",stateVO);
		return new ModelAndView("/admin/addState");		
	}
	
	@GetMapping(value = "/admin/deleteState")
	public ModelAndView deleteState(@RequestParam int id) {		
		StateVO stateVO = new StateVO();
		stateVO.setId(id);
		stateVO = stateService.stateSearchById(stateVO);
		stateVO.setStateStatus(false);
		stateService.stateInsert(stateVO);
		return new ModelAndView("redirect:/admin/viewState");
	}
	
	@GetMapping(value = "/client/viewState")
	public ModelAndView viewStateToClient(Model model) {		
		List<StateVO> stateList=stateService.stateSearch();	
		model.addAttribute("stateList", stateList);
		return new ModelAndView("/client/viewState");
	}
	
	@GetMapping(value = "/admin/listState")
	public ModelAndView listStateByCountry(Model model,@RequestParam int id) {
		CountryVO countryVO=new CountryVO();
		countryVO.setId(id);
		//countryVO=countryService.countrySearchById(countryVO);
		List<StateVO> stateList=stateService.stateSearchByCountry(countryVO);
		System.out.println(stateList.get(0).getStateName());
		model.addAttribute("stateList", stateList);
		return new ModelAndView("/admin/jsonStates");
	}
}

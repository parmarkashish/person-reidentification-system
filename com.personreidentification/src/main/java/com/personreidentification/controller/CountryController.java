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
import com.personreidentification.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping(value = "/admin/loadCountry")
	public ModelAndView loadCountry(Model model) {
		model.addAttribute("countryVO",new CountryVO());
		return new ModelAndView("/admin/addCountry");
	}	

	@PostMapping(value = "/admin/addCountry")
	public ModelAndView addCountry(@ModelAttribute CountryVO countryVO) {
		countryVO.setCountryStatus(true);
		countryService.countryInsert(countryVO);	
		return new ModelAndView("redirect:/admin/loadCountry");
	}
	
	@GetMapping(value = "/admin/viewCountry")
	public ModelAndView viewCountryToAdmin(Model model) {		
		List<CountryVO> countryList=countryService.countrySearch();
		model.addAttribute("countryList",countryList);
		return new ModelAndView("/admin/viewCountry");
	}
	
	@GetMapping(value = "/admin/editCountry")
	public ModelAndView editCountry(@RequestParam int id,Model model) {			
		CountryVO countryVO=new CountryVO();
		countryVO.setId(id);
		countryVO=countryService.countrySearchById(countryVO);
		model.addAttribute("countryVO",countryVO);
		return new ModelAndView("/admin/addCountry");
	}
	
	@GetMapping(value = "/admin/deleteCountry")
	public ModelAndView deleteCountry(@RequestParam int id) {		
		CountryVO countryVO=new CountryVO();
		countryVO.setId(id);
		countryVO=countryService.countrySearchById(countryVO);
		countryVO.setCountryStatus(false);
		countryService.countryInsert(countryVO);
		return new ModelAndView("redirect:/admin/viewCountry");
	}
	
	@GetMapping(value = "/client/viewCountry")
	public ModelAndView viewCountryToClient(Model model) {		
		List<CountryVO> countryList=countryService.countrySearch();
		model.addAttribute("countryList",countryList);
		return new ModelAndView("/client/viewCountry");
	}
}

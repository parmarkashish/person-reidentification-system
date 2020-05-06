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

import com.personreidentification.model.CityVO;
import com.personreidentification.model.CountryVO;
import com.personreidentification.model.StateVO;
import com.personreidentification.service.CityService;
import com.personreidentification.service.CountryService;
import com.personreidentification.service.StateService;

@Controller
public class CityController {
	
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	@Autowired
	CityService cityService;
	
	@GetMapping(value = "/admin/loadCity")
	public ModelAndView loadCity(Model model) {		
		List<CountryVO> countryList=countryService.countrySearch();
		List<StateVO> stateList=stateService.stateSearch();
		model.addAttribute("countryList", countryList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityVO",new CityVO());
		return new ModelAndView("/admin/addCity");
	}
	
	@PostMapping(value = "/admin/addCity")
	public ModelAndView addCity(@ModelAttribute CityVO cityVO) {		
		cityVO.setCityStatus(true);
		cityService.cityInsert(cityVO);		
		return new ModelAndView("redirect:/admin/loadCity");
	}	

	@GetMapping(value = "/admin/viewCity")
	public ModelAndView viewCityToAdmin(Model model){		
		List<CityVO> cityList=cityService.citySearch();		
		model.addAttribute("cityList",cityList);
		return new ModelAndView("/admin/viewCity");
	}
	
	@GetMapping(value = "/admin/editCity")
	public ModelAndView editCity(@RequestParam int id,Model model){			
		CityVO cityVO=new CityVO();
		cityVO.setId(id);
		cityVO=cityService.citySearchById(cityVO);
		List<CountryVO> countryList=countryService.countrySearch();
		List<StateVO> stateList=stateService.stateSearch();
		model.addAttribute("countryList", countryList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("cityVO",cityVO);
		return new ModelAndView("/admin/addCity");
	}
	
	@GetMapping(value = "/admin/deleteCity")
	public ModelAndView deleteCity(@RequestParam int id) {		
		CityVO cityVO=new CityVO();
		cityVO.setId(id);
		cityVO=cityService.citySearchById(cityVO);
		cityVO.setCityStatus(false);
		cityService.cityInsert(cityVO);		
		return new ModelAndView("redirect:/admin/viewCity");
	}

	@GetMapping(value = "/client/viewCity")
	public ModelAndView viewCityToClient(Model model){		
		List<CityVO> cityList=cityService.citySearch();		
		model.addAttribute("cityList",cityList);
		return new ModelAndView("/client/viewCity");
	}
	
	@GetMapping(value = "/admin/listCity")
	public ModelAndView listStateByCountry(Model model,@RequestParam int id) {
		StateVO stateVO=new StateVO();
		stateVO.setId(id);
		List<CityVO> cityList=cityService.citySearchByState(stateVO);
		model.addAttribute("cityList", cityList);
		return new ModelAndView("/admin/jsonCities");
	}
	

	

}

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
import com.personreidentification.model.PackageVO;
import com.personreidentification.service.PackageService;

@Controller
public class PackageController {
	@Autowired
	private PackageService packageService;
	
	@GetMapping(value = "/admin/loadPackage")
	public ModelAndView loadPackage(Model model) {
		model.addAttribute("packageVO",new PackageVO());
		return new ModelAndView("/admin/addPackage");
	}	
	
	@PostMapping(value = "/admin/addPackage")
	public ModelAndView addPackage(@ModelAttribute PackageVO packageVO) {
		packageVO.setPackageStatus(true);
		packageService.packageInsert(packageVO);	
		return new ModelAndView("redirect:/admin/loadPackage");
	}
	
	@GetMapping(value = "/admin/viewPackage")
	public ModelAndView viewPackage(Model model) {		
		List<PackageVO> packageList=packageService.packageSearch();
		model.addAttribute("packageList",packageList);
		return new ModelAndView("/admin/viewPackage");
	}
	
	@GetMapping(value = "/admin/editPackage")
	public ModelAndView editPackage(@RequestParam int id,Model model) {			
		PackageVO packageVO=new PackageVO();
		packageVO.setId(id);
		packageVO=packageService.packageSearchById(packageVO);
		model.addAttribute("packageVO",packageVO);
		return new ModelAndView("/admin/addPackage");
	}
	
	@GetMapping(value = "/admin/deletePackage")
	public ModelAndView deletePackage(@RequestParam int id) {		
		PackageVO packageVO=new PackageVO();
		packageVO.setId(id);
		packageVO=packageService.packageSearchById(packageVO);
		packageVO.setPackageStatus(false);
		packageService.packageInsert(packageVO);
		return new ModelAndView("redirect:/admin/viewPackage");
	}

}

package com.personreidentification.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.service.LoginService;
import com.personreidentification.service.VideoService;

@Controller
public class LoginController {
	
	@Autowired
	VideoService videoService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping(value="/")
	public ModelAndView loadLogin() {
		return new ModelAndView("/login");
	}
	 
	@GetMapping(value = "/login")
	public ModelAndView load() {
		return new ModelAndView("/login");
	}
	
	@GetMapping(value = "/403")
	public ModelAndView load403() {
		return new ModelAndView("/login");
	}
	
	@GetMapping(value = "/error")
	public ModelAndView error() {
		return new ModelAndView("/login");
	}
	
	@GetMapping(value = "/admin/index")
	public ModelAndView adminIndex(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		int n=videoService.getNumberOfVideos();
		int users=loginService.getLoginVO().size();
		model.addAttribute("number", n);
		model.addAttribute("users", users);
		return new ModelAndView("/admin/index");
	}
	
	@GetMapping(value = "/client/index")
	public ModelAndView userIndex(Model model) {
		int n=videoService.getNumberOfVideos();
		model.addAttribute("number", n);
		return new ModelAndView("/client/index");
	}
	
	@GetMapping(value = "/logout")	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "login";
	}

}

package com.personreidentification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.CountryVO;
import com.personreidentification.model.FeedbackVO;

import com.personreidentification.service.FeedbackService;
import com.personreidentification.service.LoginService;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	LoginService loginService;
	
	@GetMapping(value = "/client/loadFeedback")
	public ModelAndView loadFeedback(Model model) {
		model.addAttribute("feedbackVO",new FeedbackVO());
		return new ModelAndView("/client/addFeedback");
	}	
	
	@PostMapping(value = "/client/addFeedback")
	public ModelAndView addCountry(@ModelAttribute FeedbackVO feedbackVO) {
		feedbackVO.setStatus(true);
		feedbackVO.setLoginVO(loginService.getLoginVOByUser());
		feedbackService.feedbackInsert(feedbackVO);			
		return new ModelAndView("redirect:/client/loadFeedback");
	}
	
	@GetMapping(value = "/client/viewFeedback")
	public ModelAndView viewFeedbackToClient(Model model) {		
		List<FeedbackVO> feedbackList=feedbackService.feedbackSearchByLoginVO(loginService.getLoginVOByUser());
		model.addAttribute("feedbackList",feedbackList);
		return new ModelAndView("/client/viewFeedback");
	}
	
	@GetMapping(value = "/admin/viewFeedback")
	public ModelAndView viewComplainToAdmin(Model model){		
		List<FeedbackVO> feedbackList=feedbackService.feedbackSearch();
		model.addAttribute("feedbackList", feedbackList);
		return new ModelAndView("/admin/viewFeedback"); 
	}

}

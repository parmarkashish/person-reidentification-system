package com.personreidentification.controller;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.service.ComplainService;
import com.personreidentification.service.LoginService;
import com.personreidentification.utils.BaseMethod;



@Controller
public class ComplainController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private ComplainService complainService;

	@GetMapping(value = "/client/loadComplain")
	public ModelAndView loadComplain(Model model) {			
		model.addAttribute("complainVO",new ComplainVO());
		return new ModelAndView("/client/addComplain");
	}
	
	@PostMapping(value = "/client/addComplain")
	public ModelAndView addComplain(@ModelAttribute ComplainVO complainVO,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		complainVO.setComplainDate(dtf.format(now));  
		complainVO.setComplainStatus("pending");				
		complainVO.setLoginVO(loginService.getLoginVOByUser());
		complainVO.setStatus(true);
		String path=request.getSession().getServletContext().getRealPath("/documents/complain");
		File temp=BaseMethod.convertToFile(file,path);
		String s3link=BaseMethod.saveToS3(temp,"Complain");
		complainVO.setS3link(s3link);
		complainVO.setReply(null);
		complainVO.setReplyDate(null);		
		complainService.complainInsert(complainVO);		
		return new ModelAndView("redirect:/client/loadComplain");
	}
	
	@GetMapping(value = "/client/viewComplain")
	public ModelAndView viewComplainToClient(Model model){		
		List<ComplainVO> complaiinList=complainService.complainSearchByLoginVO(loginService.getLoginVOByUser());
		model.addAttribute("complainList", complaiinList);
		return new ModelAndView("/client/viewComplain"); 
	}
	
	@GetMapping(value = "/admin/viewComplain")
	public ModelAndView viewComplainToAdmin(Model model){		
		List<ComplainVO> complainList=complainService.complainSearch();
		model.addAttribute("complainList", complainList);
		return new ModelAndView("/admin/viewComplain"); 
	}
	
	@GetMapping(value = "/admin/loadReply")
	public ModelAndView loadReply(@RequestParam int id,Model model){		
		ComplainVO complainVO=new ComplainVO();
		complainVO.setId(id);
		complainVO=complainService.complainSearchById(complainVO);
		model.addAttribute("complainVO", complainVO);
		return new ModelAndView("/admin/addReply"); 
	}
	
	@PostMapping(value = "/admin/addReply")
	public ModelAndView addReply(@ModelAttribute ComplainVO complainVO) {
		ComplainVO complainVO1=complainService.complainSearchById(complainVO);
		complainVO1.setReply(complainVO.getReply());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		complainVO1.setReplyDate(dtf.format(now));  
		complainVO1.setComplainStatus("resolved");		
		complainService.complainInsert(complainVO1);
		return new ModelAndView("redirect:/admin/viewComplain");
	}
	
}

package com.personreidentification.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.VideoVO;
import com.personreidentification.service.LoginService;
import com.personreidentification.service.VideoService;
import com.personreidentification.utils.BaseMethod;

@Controller
@RestController
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping(value = "/client/loadVideo")
	public ModelAndView loadVideo(Model model) {
		return new ModelAndView("/client/addVideo");
	}	
	
	@PostMapping("/client/addVideo")
	public ModelAndView addVideo(@RequestParam("video") MultipartFile video,@RequestParam("date") String date,HttpServletRequest request,Model model) throws IOException, ParseException{
		String path="F://Input_Videos";
		File temp=BaseMethod.convertToFile(video,path);
		System.out.println(date);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateObject = format.parse(date);
		Date today = format.parse(format.format(new Date()));
		//System.out.println(date);
		VideoVO videoVO= new VideoVO();
		videoVO.setLoginVO(loginService.getLoginVOByUser());
		videoVO.setVideoDate(dateObject);
		videoVO.setUploadDate(today);
		videoVO.setVideoName(video.getOriginalFilename());
		videoVO.setVideoStatus(true);
		videoVO.setInputLink(path+"//files//"+video.getOriginalFilename());
		System.out.println(video.getName());
		System.out.println(video.getOriginalFilename());
		videoService.videoInsert(videoVO);
		model.addAttribute("videoVO", videoVO);
		return new ModelAndView("/client/processVideo");
		
	}
	
	@GetMapping(value = "/client/viewVideo")
	public ModelAndView viewVideo(Model model) {	
		
		List<VideoVO> videoList=videoService.videoSearchByLoginVO(loginService.getLoginVOByUser());
		model.addAttribute("videoList",videoList);
		return new ModelAndView("/client/viewVideo");
	}
	
	@GetMapping(value = "/client/showVideo")
	public ModelAndView showVideo(@RequestParam("id") String id,Model model) {	
		
		VideoVO videoVO=new VideoVO();
		videoVO.setId(Integer.parseInt(id));
		videoVO=videoService.videoSearchById(videoVO);

		model.addAttribute("videoVO",videoVO);
		return new ModelAndView("/client/showVideo");
	}
	
	
	@GetMapping("/client/processVideo")
	public ModelAndView processVideo(@RequestParam("id") String id,@RequestParam("link") String link) {
		System.out.println(link);
		System.out.println(id);
		VideoVO videoVO=new VideoVO();
		videoVO.setId(Integer.parseInt(id));
		videoVO=videoService.videoSearchById(videoVO);
		videoVO.setOutputLink(link);
		videoService.videoInsert(videoVO);
		
		//System.out.println("I am here"+videoVO.getVideoName());
		return new ModelAndView("/client/index");
	}
	
	@GetMapping(value = "/client/deleteVideo")
	public ModelAndView deleteVideo(@RequestParam String id) {
		
		VideoVO videoVO=new VideoVO();
		videoVO.setId(Integer.parseInt(id));
		videoVO=videoService.videoSearchById(videoVO);
		videoVO.setVideoStatus(false);
		videoService.videoInsert(videoVO);
		return new ModelAndView("/client/index");
	}
	

	/*@PostMapping(value = "/admin/addCountry")
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
	}*/
}

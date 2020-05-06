package com.personreidentification.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.personreidentification.model.DatasetVO;
import com.personreidentification.service.DatasetService;
import com.personreidentification.utils.BaseMethod;

@Controller
public class DatasetController {
	
	@Autowired
	private DatasetService datasetService;

	@GetMapping("/admin/loadDataset")
	public ModelAndView loadDataset(Model model){
		model.addAttribute("datasetVO",new DatasetVO());
		return new ModelAndView("/admin/addDataset");
	}
	
	@PostMapping("/admin/addDataset")
	public ModelAndView addDataset(@ModelAttribute DatasetVO datasetVO,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
		String path=request.getSession().getServletContext().getRealPath("/documents/dataset");
		File temp=BaseMethod.convertToFile(file,path);
		String s3link=BaseMethod.saveToS3(temp,"Dataset");
		datasetVO.setS3link(s3link);
		datasetVO.setDatasetStatus(true);
		datasetService.datasetInsert(datasetVO);
		return new ModelAndView("redirect:/admin/loadDataset");
	}
	
	@GetMapping("/admin/viewDataset")
	public ModelAndView viewDatasetToAdmin(Model model){
		List<DatasetVO> datasetList=datasetService.datasetSearch();
		model.addAttribute("datasetList",datasetList);
		return new ModelAndView("/admin/viewDataset");
		
	}
	
	@GetMapping("/admin/editDataset")
	public ModelAndView editDataset(@RequestParam int id,Model model){
		DatasetVO datasetVO=new DatasetVO();
		datasetVO.setId(id);
		datasetVO=datasetService.datasetSearchById(datasetVO);
		model.addAttribute("datasetVO", datasetVO);
		return new ModelAndView("/admin/addDataset");
		
	}
	
	@GetMapping("/admin/deleteDataset")
	public ModelAndView deleteDataset(@RequestParam int id,Model model){
		DatasetVO datasetVO=new DatasetVO();
		datasetVO.setId(id);
		datasetVO=datasetService.datasetSearchById(datasetVO);
		datasetVO.setDatasetStatus(false);
		datasetService.datasetInsert(datasetVO);
		return new ModelAndView("redirect:/admin/viewDataset");
		
	}	
	
	@GetMapping("/client/viewDataset")
	public ModelAndView viewDatasetToClient(Model model){
		List<DatasetVO> datasetList=datasetService.datasetSearch();
		model.addAttribute("datasetList",datasetList);
		return new ModelAndView("/client/viewDataset");
		
	}
	
}

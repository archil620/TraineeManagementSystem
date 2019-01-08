package com.igate.tms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.igate.tms.bean.IdTrainee;
import com.igate.tms.bean.Trainee;
import com.igate.tms.bean.User;
import com.igate.tms.service.TraineeService;

@Controller
public class TraineeController {

	@Autowired
	TraineeService service;
	
	List<String> traineeLoc=null;
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin(Model model){
		
		model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/validateform")
	public String validateLogin(@ModelAttribute("user") @Valid User user,
			BindingResult result,Model model){
		
		if(result.hasErrors())
			return "login";
		
		boolean valid = service.validateUser(user);
	
		if(valid)
			return "home";
		else
			return "error";
	}
	
	@RequestMapping(value="/addTrain")
	public String addTrainee(Model model){
		
		model.addAttribute("trainee",new Trainee());
		traineeLoc= new ArrayList<String>();
		
		traineeLoc.add("Chennai");
		traineeLoc.add("Mumbai");
		traineeLoc.add("Pune");
		traineeLoc.add("Banglore");
		
		model.addAttribute("traineeLoc",traineeLoc);
		
		return "addTrainee";
	}
	
	@RequestMapping(value="/addtraining")
	public String addNewTrainee(@ModelAttribute("trainee") @Valid Trainee trainee,
							BindingResult result, Model model){
		try{
			if(result.hasErrors()){
				model.addAttribute("traineeLoc",traineeLoc);
				return "addTrainee";
			}
			int rowCount = service.addTrainee(trainee);
			System.out.println("before cout");
			for(String s:trainee.getLocation())
				System.out.println(s);
			
				if(rowCount!=0){
					System.out.println(rowCount);
					model.addAttribute("idcount",rowCount);
					return "registerSuccess";
				}else
					return "error";
		}
		catch(DataAccessException e){
			String msg = "Error Occured while Adding!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	@RequestMapping(value="/delTrainee.obj")
	public String deleteTrainee(@ModelAttribute("trainee") Trainee trainee){
		return "delete";
	}
	
	@RequestMapping(value="/showDelTrainee")
	public String showDelTrainee(@ModelAttribute("trainee") @Valid IdTrainee trainee,
			BindingResult result,Model model){

		try{
			
			if(result.hasErrors())
				return "delete";
			
			Trainee t = service.showTrainee(trainee);
			model.addAttribute("delTrainee",t);
			return "delete";
		}catch(EmptyResultDataAccessException r){
			String msg = "No Data found for " + trainee.getTraineeId();
			model.addAttribute("msg",msg);
			return "myerror";
		}catch(DataAccessException e){
			String msg = "Error Occured while Dispyaing Data in deleting!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	
	@RequestMapping(value="/delTrain")
	public String delTrainee(@ModelAttribute("trainee") Trainee trainee,
			@RequestParam(value="del") String s,Model model){
		try{
			int id = Integer.parseInt(s);
			trainee.setTraineeId(id);
			int count = service.delTrainee(trainee);
			if(count!=0){
				model.addAttribute("id",id);
				return "deleteSuccess";
			}else
				System.out.println("Not deleted");
				return "delete";
		}catch(DataAccessException e){
			String msg = "Error Occured while deleting!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	@RequestMapping(value="/retrieve")
	public String retrieveTrainee(Model model){
		model.addAttribute("retrieve",new Trainee());
		return "retrieve";
	}
	
	
	@RequestMapping(value="/retrieveTrainee")
	public String retrieveById(@ModelAttribute("retrieve") @Valid IdTrainee trainee,
			BindingResult result,Model model){
		try{
			
			if(result.hasErrors())
				return "retrieve";
			
			Trainee retrieveTrainee = service.showTrainee(trainee);
			model.addAttribute("retTrain",retrieveTrainee);
			return "retrieve";
		}catch(EmptyResultDataAccessException r){
			String msg = "No Data found for " + trainee.getTraineeId();
			model.addAttribute("msg",msg);
			return "myerror";
		}catch(DataAccessException e){
			String msg = "Error Occured while retrieving!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	@RequestMapping(value="/modifyTrainee")
	public String modify(@ModelAttribute("trainee") Trainee trainee){
		return "modify";
	}
	
	@RequestMapping(value="/modifybyID")
	public String modifyById(@ModelAttribute("trainee") @Valid IdTrainee trainee,
			BindingResult result,Model model){
		try{
			
			if(result.hasErrors())
				return "modify";
			
			Trainee modifyTrain = service.showTrainee(trainee);
			model.addAttribute("modifyTrain",modifyTrain);
			return "modify";
		}catch(EmptyResultDataAccessException r){
			String msg = "No Data found for " + trainee.getTraineeId();
			model.addAttribute("msg",msg);
			return "myerror";
		}catch(DataAccessException e){
			String msg = "Error Occured while Displaying details in modify module!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	@RequestMapping(value="/modTrain")
	public String modTrain(@ModelAttribute("trainee") Trainee trainee,
			@RequestParam(value="del") String id,
			//@RequestParam(value="tname") String name,
			@RequestParam(value="tdomain") String domain,
			@RequestParam(value="tloc") String loc,
			Model model){
		
		try{
			int mid = Integer.parseInt(id);
			trainee.setTraineeId(mid);
			System.out.println(trainee.getTraineeName());
			trainee.setTraineeName(trainee.getTraineeName());
			trainee.setTraineeLocation(loc);
			trainee.setTraineeDomain(domain);
		
			int count = service.modifyTrainee(trainee);
			if(count!=0){	
				model.addAttribute("id",mid);
				return "modifySuccess";
			}
			else
				System.out.println("not modified!");
			return "modify";
		}catch(DataAccessException e){
			String msg = "Error Occured in modify module!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
	@RequestMapping(value="/retrieveall")
	public String retrieveAll(@ModelAttribute("trainee") Trainee trainee,Model model){
		try{
			List<Trainee> traineeList = service.retrieveAll();
		
			for(Trainee t:traineeList)
				System.out.println(t);
		
			model.addAttribute("tList",traineeList);
		
			return "retrieveAll";
		}catch(DataAccessException e){
			String msg = "Error Occured in retrieveAll module!";
			model.addAttribute("msg",msg);
			return "myerror";
		}
	}
	
}

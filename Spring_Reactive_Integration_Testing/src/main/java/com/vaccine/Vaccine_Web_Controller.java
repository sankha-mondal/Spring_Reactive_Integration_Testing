package com.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

@Controller
public class Vaccine_Web_Controller {
	
	@Autowired
	private Vaccine_Service service;
	
//=====================================================================================================================

	//  localhost:8585/get_Vaccines_web
	
	@GetMapping("/get_Vaccines_web")
	public Mono<String> get_Vaccines_web(Model model) {
		model.addAttribute("vaccines", service.get_Vaccines());
		return Mono.just("index");
	}
	
	//  localhost:8585/get_Vaccines_availability_web
	
	@GetMapping("/get_Vaccines_availability_web")
	public Mono<String> get_Vaccines_Availability_web(Model model) {
		model.addAttribute("vaccines", service.get_Vaccines_Availability());
		return Mono.just("index");
	}
	
	
//=====================================================================================================================

	
	
 }

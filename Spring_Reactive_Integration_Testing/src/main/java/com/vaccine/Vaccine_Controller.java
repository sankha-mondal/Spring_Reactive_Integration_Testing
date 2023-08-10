package com.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Vaccine_Controller { // no need to create Subscriber

	@Autowired
	private Vaccine_Service service;

//======================================================================================================================

	// localhost:8585/get_Vaccines

	@GetMapping("/get_Vaccines")
	public Flux<Vaccine> get_Vaccines() {
		return service.get_Vaccines();
	}

	// localhost:8585/get_Vaccines_Availability

	@GetMapping("/get_Vaccines_Availability")
	public Flux<Vaccine> get_Vaccines_Availability() {
		return service.get_Vaccines_Availability();
	}

}

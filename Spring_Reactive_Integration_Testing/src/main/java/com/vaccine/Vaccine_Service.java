package com.vaccine;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class Vaccine_Service {

	public Flux<Vaccine> get_Vaccines() {
		return Flux.just(new Vaccine("Pfizer"), new Vaccine("J&J"), new Vaccine("Cov"));  // Covaxin
	}
	
	public Flux<Vaccine> get_Vaccines_Availability() {
		return Flux.just(new Vaccine("Pfizer",true), new Vaccine("J&J",false), new Vaccine("Covaxin", true));
	}

}

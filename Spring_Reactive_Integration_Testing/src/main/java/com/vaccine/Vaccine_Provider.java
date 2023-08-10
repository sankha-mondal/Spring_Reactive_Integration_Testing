package com.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class Vaccine_Provider {
	
	@Autowired
	private Vaccine_Service service;

	public Flux<Vaccine> providerVaccines() {
		return service.get_Vaccines().map(this::deliver);
	}
	
	private Vaccine deliver(Vaccine vaccine) {
		vaccine.setDelivered(true);
		return vaccine;
	}
}

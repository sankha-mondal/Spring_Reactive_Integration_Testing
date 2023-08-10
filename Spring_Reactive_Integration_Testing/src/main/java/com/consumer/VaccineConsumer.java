package com.consumer;

import java.util.function.Consumer;

import com.vaccine.Vaccine;

public class VaccineConsumer implements Consumer<Vaccine> {

	@Override
	public void accept(Vaccine vaccine) {
		// TODO Auto-generated method stub
		System.out.println(vaccine.getName());
		System.out.println(vaccine.isDelivered());
	}

}

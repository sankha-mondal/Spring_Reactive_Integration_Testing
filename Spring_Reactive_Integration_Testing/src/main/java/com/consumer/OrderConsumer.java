package com.consumer;

import java.util.function.Consumer;

public class OrderConsumer implements Consumer<String> {

	@Override
	public void accept(String data) {
		// TODO Auto-generated method stub
		System.out.println(data);
	}

}

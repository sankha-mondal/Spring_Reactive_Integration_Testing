package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.consumer.OrderConsumer;
import com.consumer.VaccineConsumer;
import com.vaccine.Vaccine;
import com.vaccine.Vaccine_Provider;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringReactiveProjectApplicationTests {
	
	@Autowired
	Vaccine_Provider provider;
	
//=============================================================================================================================================
	
	//  Working with create(), expectSubscription(), expectNext(), expectComplete(), verify()
	
	@Test
	void test_VaccineProvider_reactive() {
		StepVerifier.create(provider.providerVaccines())
				.expectSubscription()
				.expectNext(new Vaccine("Pfizer"))
				.expectNext(new Vaccine("J&J"))
				.expectNext(new Vaccine("Cov"))  // Covaxin
				.expectComplete()
				.verify();
	}
	
	//  Working with expectNextCount()
	
	@Test
	void test_VaccineProvider_reactive_expectNextCount() {
		StepVerifier.create(provider.providerVaccines())
				.expectSubscription()
				.expectNextCount(3)
				.expectComplete()
				.verify();
	}
	
	//  Working with assertThat()
	
	@Test
	void test_VaccineProvider_reactive_assertThat() {
		StepVerifier.create(provider.providerVaccines())
				.expectSubscription()
				.assertNext(vaccine-> {
					assertThat(vaccine.getName()).isNotNull();
					assertTrue(vaccine.isDelivered());
					assertEquals("Pfizer", vaccine.getName());
				})
				.expectNext(new Vaccine("J&J"))
				.expectNext(new Vaccine("Cov")) 
				.expectComplete()
				.verify();
	}
	
	
	//  Working with assertThat_thenConsumeWhile()
	
	@Test
	void test_VaccineProvider_reactive_assertThat_thenConsumeWhile() {
		StepVerifier.create(provider.providerVaccines())
				.expectSubscription()
				.assertNext(vaccine-> {
					assertThat(vaccine.getName()).isNotNull();
					assertTrue(vaccine.isDelivered());
					assertEquals("Pfizer", vaccine.getName());
				})
				.thenConsumeWhile(vaccine->{
					System.out.println("Veccine Name while consuming: "+vaccine.getName());
					return true;
				})
				.expectComplete()
				.verify();
	}
	
	
//=============================================================================================================================================
	
	@Test
	void test_VaccineProvider() {
		provider.providerVaccines().subscribe(new VaccineConsumer());
	}	
	

}

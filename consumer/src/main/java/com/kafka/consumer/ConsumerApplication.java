package com.kafka.consumer;

import org.json.JSONException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.consumer.configuration.ConsumerConfiguration;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws JSONException {

		ConsumerConfiguration C = new ConsumerConfiguration();
		C.consume();
	}

}

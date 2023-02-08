package com.kafka.producer;

import org.json.JSONException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.configurations.ProducerConfiguration;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) throws JSONException {

		ProducerConfiguration producer = new ProducerConfiguration();
//		get socket port and localhost throw env file
		String host = System.getenv("host");
		String socket = System.getenv("socket_port");
		if (socket == null) {
		  // Handle the error, as the environment variable is not set
		}
		int socketPort = Integer.parseInt(socket);
//		get the socket port throw env file 
		producer.Client1(host,socketPort);
		
//		connect socket without env 
//		producer.Client1("localhost", 12345);
		
//		To connect socket server in docker-compose 
//		producer.Client1("sockets", 12345);

	}
}
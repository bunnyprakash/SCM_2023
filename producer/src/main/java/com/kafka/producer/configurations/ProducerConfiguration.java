package com.kafka.producer.configurations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Document;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.mongodb.client.MongoCollection;

public class ProducerConfiguration {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	// initialize socket and input output streams
	private Socket socket = null;
	private BufferedReader input = null;
	private BufferedWriter output = null;
	private MongoCollection<Document> collection = null;

	// constructor to put ip address and port
	public void Client1(String address, int port) throws JSONException {
		
		// establish a connection
		try {
			socket = new Socket(address, port);
			
			// takes input from terminal
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// sends output to the socket
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (UnknownHostException u) {
			
			
		} catch (IOException i) {
			
		}
		
		// string to read message from input
		String line = "";

		while (!line.equals("Over")) {
			

			try {
				line = input.readLine();
				JSONArray array = new JSONArray(line);

				for (int i = 0; i < array.length(); i++) {
					JSONObject object = array.getJSONObject(i);
				
					KafkaTemplate<String, String> kafkaTemplate = kafkaTemplate();
					kafkaTemplate.send("Producer", object.toString());
		
				}
			}
			catch (IOException i) {
			       throw new IllegalArgumentException("Unable to load ");

			}
		}
		// close the connection
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException i) {
		       throw new IllegalArgumentException("Unable to load ");

			
		}
	}

	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerConfig());
	}

	public ProducerFactory<String, String> producerConfig() {

		Map<String, Object> config = new HashMap<>();
		
		String bootstrap_server = System.getenv("bootstrap_server");
//		server with env file
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server);
		
//		server with localhost
//		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		
//		To connect in docker-compose file
//		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);

	}

}

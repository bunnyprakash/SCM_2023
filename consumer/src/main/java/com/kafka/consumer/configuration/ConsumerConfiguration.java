package com.kafka.consumer.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.bson.Document;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;

import java.util.Properties;

@Component
public class ConsumerConfiguration{

	private static MongoCollection<Document> Devicecollection = null;

	public void consume() throws JSONException {
		
//		To get the mongo connection string uri which we set in environment varible
        String mongodbUri = System.getenv("uri");
  
		try {
//			mongo uri to pass connection string directly
//			MongoClientURI uri = new MongoClientURI(mongourl);
			
			MongoClient mongoClient = MongoClients.create(mongodbUri);

			 MongoDatabase db = mongoClient.getDatabase("scm");
			Devicecollection = db.getCollection("Devices");

		}

		catch (Exception e) {
			// handle server down or failed query here.
		}
		Logger logger = LoggerFactory.getLogger(ConsumerConfiguration.class.getName());
//		get bootstrap port throw env
		String bootstrap_port = System.getenv("bootstrapServer");
		String bootstrapServers = bootstrap_port;
		
//		connect bootstrap with localhost
//		String bootstrapServers = "127.0.0.1:9092";
		
//		server to connect in docker-compose 
		//String bootstrapServers = "kafka:9092";
		
//		get grp_ids  name throw env
		String grp_ids = System.getenv("grp_id");
		String grp_id = grp_ids;
		
//		get topic name throw env
		String topics = System.getenv("topic");
		String topic = topics;
		

		// Creating consumer properties
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, grp_id);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		// creating consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

		// Subscribing
		consumer.subscribe(Arrays.asList(topic));
		// polling
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {

				logger.info("Key: " + record.key() + ", Value:" + record.value());
				logger.info("Partition:" + record.partition() + ",Offset:" + record.offset());
				Document doc = Document.parse(record.value());
				Devicecollection.insertOne(doc);

			}

		}

	}

}

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Shipment;


@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> 
{

	List<Shipment> findByShipmentNumber(int shipmentNumber);
	
	boolean existsByShipmentNumber(int shipmentNumber);

}

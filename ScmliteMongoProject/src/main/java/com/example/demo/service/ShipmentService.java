package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ShipmentRepository;
import com.example.demo.model.Shipment;
@Service
public class ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepository;

	public String saveShipment(Shipment shipment) {
		
		boolean flag = shipmentRepository.existsByShipmentNumber(shipment.getShipmentNumber());
		if(!flag) {
			shipmentRepository.save(shipment);
			return shipment.getShipmentNumber() + " Is Created Successfully ";
		}
		
		return shipment.getShipmentNumber() + " Already Exists !!! ";
		
	}
}

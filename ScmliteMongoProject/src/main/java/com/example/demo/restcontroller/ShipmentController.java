package com.example.demo.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Shipment;
import com.example.demo.service.ShipmentService;
@RestController
@RequestMapping("/shipment")
public class ShipmentController {
	
	@Autowired
	ShipmentService shipmentservice;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	private String create(@RequestBody Shipment shipment ) {
		return shipmentservice.saveShipment(shipment);
    }
	
}

package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection="Shipmentdetails")
public class Shipment
{
	

	private int shipmentNumber;
	private int containerNumber;
	private String descripton;
	private String route;
	private String goods;
	private String country;
	private String deliveryDate;
	private int pONumber;
	private int deliveryNumber;
	private int nDCNumber;
	private int batchId;
	private int serialNumberOfGoods;
	public int getShipmentNumber() {
		return shipmentNumber;
	}
	public void setShipmentNumber(int shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}
	public int getContainerNumber() {
		return containerNumber;
	}
	public void setContainerNumber(int containerNumber) {
		this.containerNumber = containerNumber;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getpONumber() {
		return pONumber;
	}
	public void setpONumber(int pONumber) {
		this.pONumber = pONumber;
	}
	public int getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(int deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public int getnDCNumber() {
		return nDCNumber;
	}
	public void setnDCNumber(int nDCNumber) {
		this.nDCNumber = nDCNumber;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getSerialNumberOfGoods() {
		return serialNumberOfGoods;
	}
	public void setSerialNumberOfGoods(int serialNumberOfGoods) {
		this.serialNumberOfGoods = serialNumberOfGoods;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}

package com.AutoHero.Assignment.gui.pages;

public class VehicleDetails {

	private String VehicleName ; 
	private int Mileage ;
	
	public VehicleDetails(String VehicleName, int Mileage) {
		this.VehicleName=VehicleName;
		this.Mileage=Mileage;
	}

	public int getMileage() {
		return Mileage;
	}

	public String getVehicleName() {
		return VehicleName;
	}
	
}

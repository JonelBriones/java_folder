package com.caresoft.clinicapp;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...
    
    public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
//
//	// Inside class:    
//    private ArrayList<String> patientNotes;
//	
//    // TO DO: Constructor that takes an ID
//    // TO DO: Implement HIPAACompliantUser!
//	
//    public void newPatientNotes(String notes, String patientName, Date date) {
//        String report = String.format(
//            "Datetime Submitted: %s \n", date);
//        report += String.format("Reported By ID: %s\n", this.id);
//        report += String.format("Patient Name: %s\n", patientName);
//        report += String.format("Notes: %s \n", notes);
//        this.patientNotes.add(report);
//    }

	@Override
	public boolean assignPin(int pin) {
		if(pin < 1000 || pin > 9999) {
			return false;
		}
		this.pin = pin; //this.pin belongs to physician pin is the past down pin
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (confirmedAuthID == this.id) {
			return true;
		}
		
		return false;
	}
	
    // TO DO: Setters & Getters

}

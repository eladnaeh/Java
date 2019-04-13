package com.company;

import javax.print.Doc;
import java.sql.Time;

public class Appointment {

    private int id;
    private String appointmentTime;
    private Doctor doctor;
    private String description;

    private String userName;
    private String userPhoneNumber;

    public Appointment(int id, Doctor doctor, String appointmentTime, String description, String userName, String userPhoneNumber){
        this.id = id;
        this.doctor = doctor;
        this.appointmentTime = appointmentTime;
        this.description = description;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String toString() {
        return "Appointment id: "+ id + " , " + "Appointment Time: " + appointmentTime + " ,Description: " + description + " ,userName: " + userName +
                " ,user's phone number: " + userPhoneNumber + " , doctor: " + doctor.getFullName() + ".";
    }
}

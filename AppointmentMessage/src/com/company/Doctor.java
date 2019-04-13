package com.company;

import java.util.ArrayList;

public class Doctor {

    private String name;
    private String lastName;
    private ArrayList<Appointment> scheduledAppointments;
    private int capacity;

    public Doctor(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        this.scheduledAppointments = new ArrayList<>();
        this.capacity = 10;
    }

    public void addAppointment(int userId, String userName, String userPhoneNumber, String time, String message){
        if(scheduledAppointments.size() < capacity){
            scheduledAppointments.add(new Appointment(userId, this, time, message, userName, userPhoneNumber));
        }
    }

    public void removeAppointment(int id){
        scheduledAppointments.remove(position(id));
    }

    public ArrayList<Appointment> getScheduledAppointments() {
        return scheduledAppointments;
    }

    public void printScheduledAppointments(){
        for(Appointment appointment : scheduledAppointments){
            System.out.println(appointment);
        }
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }

    public int position(int id){
        for(int i=0; i<scheduledAppointments.size(); i++){
            Appointment appointment = scheduledAppointments.get(i);
            if(appointment.getId() == id){
                return i;
            }
        }
        return -1;
    }
}

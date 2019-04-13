package com.company;

import javax.print.Doc;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class User extends MongoDB{

    private int id;
    private String name;
    private String phoneNumber;
    private int messagesSent;
    private ArrayList<Appointment> appointments;

    Random random = new Random();

    public User(String phoneNumber, String name){
        this.id = random.nextInt(1000) + 1;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.messagesSent = 0;
        this.appointments = new ArrayList();
    }

    public boolean addAppointment(int id, Doctor doctor, String time, String message) {
        try {
            appointments.add(new Appointment(id, doctor, time, message, this.name, this.phoneNumber));
            doctor.addAppointment(id, this.name, this.phoneNumber, time, message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeAppointment(int id){
        try{
            for(int i=0; i<appointments.size(); i++){
                if(appointments.get(i).getId() == id){

                    Doctor doctor = appointments.get(i).getDoctor();
                    appointments.remove(appointments.get(i));


                    System.out.println(doctor.getFullName());
                    doctor.removeAppointment(id);
                    return true;
                }
            }
            System.out.println("the id: " + id + " wasn't found");
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean changeAppointmentDoctor(int id, Doctor doctor){
        try{
            for(int i=0; i<appointments.size(); i++){
                Appointment appointment = appointments.get(i);
                if(appointment.getId() == id){

                    appointment.getDoctor().removeAppointment(appointment.getId());

                    doctor.addAppointment(appointment.getId(), appointment.getUserName(), appointment.getUserPhoneNumber(),
                            appointment.getAppointmentTime(), appointment.getDescription());

                    appointment.setDoctor(doctor);
                    //remove from first doctor and add to the other one
                    return true;
                }
            }
            System.out.println("the id: " + id + " wasn't found");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeAppointmentTime(int id, String time){
        try{
            for(int i=0; i<appointments.size(); i++){
                Appointment appointment = appointments.get(i);
                if(appointment.getId() == id){
                    appointment.setAppointmentTime(time);

                    appointment.getDoctor().getScheduledAppointments().get(appointment.getDoctor().position(id)).setAppointmentTime(time);
                    //change also in the doctor's appointments
                    return true;
                }
            }
            System.out.println("the id: " + id + " wasn't found");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeAppointmentDescription(int id, String description){
        try{
            for(int i=0; i<appointments.size(); i++){
                Appointment appointment = appointments.get(i);
                if(appointment.getId() == id){
                    appointment.setDescription(description);

                    appointment.getDoctor().getScheduledAppointments().get(appointment.getDoctor().position(id)).setDescription(description);
                    //change also in the doctor's appointments
                    return true;
                }
            }
            System.out.println("the id: " + id + " wasn't found");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void changePhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
        for (Appointment appointment : appointments){
            appointment.setUserPhoneNumber(newPhoneNumber);
            Doctor doctor = appointment.getDoctor();
            for(Appointment appointment1 : doctor.getScheduledAppointments()){
                if(appointment1.getUserName() == this.name){
                    appointment1.setUserPhoneNumber(newPhoneNumber);
                }
            }
        }

        //change in all appointments
    }

    public void changeUserName(String newUserName){
        this.name = newUserName;
        for (Appointment appointment : appointments){
            appointment.setUserName(newUserName);
            Doctor doctor = appointment.getDoctor();
            for(Appointment appointment1 : doctor.getScheduledAppointments()){
                if(appointment1.getUserPhoneNumber() == this.phoneNumber){
                    appointment1.setUserName(newUserName);
                }
            }
        }
        //change in all appointments
    }



    public ArrayList getAppointments() {
        return appointments;
    }

    public void printAppointments(){
        for(int i=0; i< appointments.size(); i++){
            System.out.println(appointments.get(i));
        }
    }

    public int getId() {
        return id;
    }
}

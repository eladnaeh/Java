package com.company;

import java.sql.Time;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class MessageClass {
    private int id;
    private String appointmentTime;
    private String sendTime;
    private String message;

    public MessageClass(int id, String appointmentTime, String sendTime, String message){
        this.id = id;
        this.appointmentTime = appointmentTime;
        this.sendTime = sendTime;
        this.message = message;
    }

    private boolean sendMessage(){
        System.out.println("New message: " + id + ":" + sendTime + "Your appointment has been set to: " + appointmentTime + ".");
        return true;
    }
}

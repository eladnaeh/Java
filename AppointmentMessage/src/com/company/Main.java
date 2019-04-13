package com.company;

public class Main {

    public static void main(String[] args) {
	    User elad = new User("0547899780", "elad");
	    User anat = new User("0544946731", "anat");
	    User shay = new User("0523424687", "shay");

	    Doctor pete = new Doctor("pete", "levine");
	    Doctor mike = new Doctor("mike", "stevens");
	    Doctor alfie = new Doctor("alfie", "peters");

	    elad.addAppointment(10, pete, "12:00", "Demo");
	    elad.addAppointment(22, mike, "14:30", "Demo2");
		elad.addAppointment(25, alfie, "16:30", "Demo3");

		elad.printAppointments();

		System.out.println("============");

		pete.printScheduledAppointments();
		System.out.println("============");
		mike.printScheduledAppointments();
		System.out.println("============");
		alfie.printScheduledAppointments();
		System.out.println("============");

	    elad.changeAppointmentDoctor(22, pete);

	    pete.printScheduledAppointments();

//	    elad.changeAppointmentDescription(25, "HELLOWORLD");
//	    elad.changeAppointmentTime(25, "11:11:11");
	    elad.changePhoneNumber("123456789");
	    elad.changeUserName("roee");

	    elad.removeAppointment(22);

		System.out.println("============Changed");
		pete.printScheduledAppointments();
		System.out.println("============PETE");
		elad.printAppointments();

		System.out.println("============");

		pete.printScheduledAppointments();
		System.out.println("============");
		mike.printScheduledAppointments();
		System.out.println("============");
		alfie.printScheduledAppointments();
		System.out.println("============");

//	    elad.printAppointments();
//	    System.out.println("=======================");
//	    pete.printScheduledAppointments();
    }
}

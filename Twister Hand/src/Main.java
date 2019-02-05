import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String chosenColor = Color();
        String chosenBodyPart = BodyPart();

        System.out.println("Place your " + BodyPart() + " on " + Color());
    }

    public static String Color(){
        Random rand = new Random();
        int number = rand.nextInt(4) + 1;
        String color;
        switch (number){
            case 1: color = "Blue";
                    break;
            case 2: color = "Red";
                    break;
            case 3: color = "Yellow";
                    break;
            case 4: color = "Green";
                    break;
            default: color = "Invalid Color";
        }
        return color;
    }

    public static String BodyPart(){
        Random rand = new Random();
        int number = rand.nextInt(4) + 1;
        String bodyPart;
        switch (number){
            case 1: bodyPart = "Right Arm";
                break;
            case 2: bodyPart = "Left Arm";
                break;
            case 3: bodyPart = "Right Leg";
                break;
            case 4: bodyPart = "Left Leg";
                break;
            default: bodyPart = "Invalid Body Part";
        }
        return bodyPart;
    }

}

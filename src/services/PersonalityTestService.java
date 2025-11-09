package service;

import java.util.Scanner;

public class PersonalityTestService {

    public String takeTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quick Personality Test:");
        System.out.println("1: Do you enjoy social gatherings? (yes/no)");
        String a1 = sc.nextLine();
        System.out.println("2: Do you rely on facts more than feelings? (yes/no)");
        String a2 = sc.nextLine();
        System.out.println("3: Do you plan ahead? (yes/no)");
        String a3 = sc.nextLine();
        System.out.println("4: Do you often think deeply? (yes/no)");
        String a4 = sc.nextLine();

        String type = "";
        type += a1.equalsIgnoreCase("yes") ? "E" : "I";
        type += a2.equalsIgnoreCase("yes") ? "S" : "N";
        type += a3.equalsIgnoreCase("yes") ? "J" : "P";
        type += a4.equalsIgnoreCase("yes") ? "T" : "F";

        System.out.println("Your personality type is: " + type);
        return type;
    }
}

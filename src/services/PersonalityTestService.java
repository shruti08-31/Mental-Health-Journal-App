package services;

import java.util.*;

public class PersonalityTestService {

    private Scanner sc = new Scanner(System.in);

    public String[] startTest() {
        System.out.println("Welcome to the 16 Personality Type Test!");
        System.out.println("Answer honestly (1 = Agree, 0 = Disagree)\n");

        int e = ask("You enjoy social gatherings more than being alone");
        int s = ask("You focus more on facts than ideas");
        int t = ask("You make decisions logically rather than emotionally");
        int j = ask("You like to plan things rather than be spontaneous");

        // Determine type
        String type = (e == 1 ? "E" : "I") +
                (s == 1 ? "S" : "N") +
                (t == 1 ? "T" : "F") +
                (j == 1 ? "J" : "P");

        String description = getDescription(type);

        System.out.println("\nYour Personality Type: " + type);
        System.out.println(description);

        return new String[]{type, description};
    }

    private int ask(String question) {
        System.out.print(question + " (1/0): ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("1") || input.equals("0")) {
                return Integer.parseInt(input);
            }
            System.out.print("Please enter 1 or 0: ");
        }
    }

    private String getDescription(String type) {
        Map<String, String> desc = new HashMap<>();

        desc.put("ISTJ", "Logistician – Responsible, organized, and reliable.");
        desc.put("ISFJ", "Defender – Warm, caring, and loyal protector.");
        desc.put("INFJ", "Advocate – Idealistic, insightful, and empathetic.");
        desc.put("INTJ", "Architect – Strategic, independent, and determined.");
        desc.put("ISTP", "Virtuoso – Practical, bold, and efficient problem-solver.");
        desc.put("ISFP", "Adventurer – Sensitive, artistic, and curious.");
        desc.put("INFP", "Mediator – Thoughtful, creative, and kind-hearted.");
        desc.put("INTP", "Logician – Analytical, curious, and innovative thinker.");
        desc.put("ESTP", "Entrepreneur – Energetic, bold, and spontaneous.");
        desc.put("ESFP", "Entertainer – Fun-loving, enthusiastic, and outgoing.");
        desc.put("ENFP", "Campaigner – Energetic, creative, and optimistic.");
        desc.put("ENTP", "Debater – Smart, curious, and loves challenges.");
        desc.put("ESTJ", "Executive – Organized, confident, and takes charge.");
        desc.put("ESFJ", "Consul – Friendly, caring, and people-oriented.");
        desc.put("ENFJ", "Protagonist – Inspiring, charismatic, and motivating.");
        desc.put("ENTJ", "Commander – Bold, confident, and natural leader.");

        return desc.getOrDefault(type, "Unique blend of traits!");
    }
}


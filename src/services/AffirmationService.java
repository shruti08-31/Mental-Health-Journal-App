package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AffirmationService {
    private List<String> affirmations = new ArrayList<>();

    public AffirmationService() {
        affirmations.add("You are enough.");
        affirmations.add("You’re doing your best.");
        affirmations.add("You deserve peace.");
        affirmations.add("You are growing every day.");
        affirmations.add("You have the power to create change.");
        affirmations.add("Your efforts will pay off.");
        affirmations.add("You are capable of amazing things.");
        affirmations.add("Every day is a fresh start.");
        affirmations.add("You are stronger than you think.");
        affirmations.add("Keep believing in yourself.");
        affirmations.add("You bring value to the world.");
        affirmations.add("Your hard work makes a difference.");
        affirmations.add("It’s okay to take a break and breathe.");
        affirmations.add("You are learning and improving daily.");
        affirmations.add("Your dreams are worth chasing.");
    }

    public String getDailyAffirmation() {
        Random rand = new Random();
        int index = rand.nextInt(affirmations.size());
        return affirmations.get(index);
    }

}

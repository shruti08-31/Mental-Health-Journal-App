package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ReflectionPrompts {

    private Map<String, List<String>> prompts;

    public ReflectionPrompts() {
        prompts = new HashMap<>();

        // Prompts for different moods
        List<String> happyPrompts = new ArrayList<>();
        happyPrompts.add("What made you smile today?");
        happyPrompts.add("Who are you grateful for today?");

        List<String> sadPrompts = new ArrayList<>();
        sadPrompts.add("What’s been bothering you?");
        sadPrompts.add("What would comfort you right now?");

        List<String> stressedPrompts = new ArrayList<>();
        stressedPrompts.add("What’s taking most of your energy?");
        stressedPrompts.add("What could you let go of today?");

        // Putting all mood prompts into the map
        prompts.put("happy", happyPrompts);
        prompts.put("sad", sadPrompts);
        prompts.put("stressed", stressedPrompts);
    }

    // Method to get a random prompt from all available prompts
    public String getRandomPrompt() {
        List<String> allPrompts = new ArrayList<>();

        // Add all prompts from all moods
        for (List<String> moodPrompts : prompts.values()) {
            allPrompts.addAll(moodPrompts);
        }

        Random random = new Random();
        int index = random.nextInt(allPrompts.size());
        return allPrompts.get(index);
    }

    // Method to get a random prompt based on user's mood
    public String getPromptByMood(String mood) {
        mood = mood.toLowerCase();
        List<String> moodPrompts = prompts.get(mood);

        if (moodPrompts == null || moodPrompts.isEmpty()) {
            return "Write whatever’s on your mind.";
        }

        Random random = new Random();
        int index = random.nextInt(moodPrompts.size());
        return moodPrompts.get(index);
    }
}


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

        List<String> happyPrompts = new ArrayList<>();
        happyPrompts.add("What made you smile today?");
        happyPrompts.add("Who are you grateful for today?");

        List<String> sadPrompts = new ArrayList<>();
        sadPrompts.add("What’s been bothering you?");
        sadPrompts.add("What would comfort you right now?");

        List<String> stressedPrompts = new ArrayList<>();
        stressedPrompts.add("What’s taking most of your energy?");
        stressedPrompts.add("What could you let go of today?");

        prompts.put("happy", happyPrompts);
        prompts.put("sad", sadPrompts);
        prompts.put("stressed", stressedPrompts);
    }

    public String getRandomPrompt() {
        List<String> allPrompts = new ArrayList<>();
        List<String> keys = new ArrayList<>(prompts.keySet());
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            List<String> moodPrompts = prompts.get(key);
            allPrompts.addAll(moodPrompts);
        }

        Random random = new Random();
        int index = random.nextInt(allPrompts.size());
        return allPrompts.get(index);
    }

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

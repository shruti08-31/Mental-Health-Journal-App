package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java.util.*;

import java.util.*;

public class ReflectionPrompts {

    private Map<String, List<String>> prompts;
    private List<String> knownKeys;

    public ReflectionPrompts() {
        prompts = new HashMap<>();
        knownKeys = new ArrayList<>();

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

        knownKeys.add("happy");
        knownKeys.add("sad");
        knownKeys.add("stressed");
    }

    public String getRandomPrompt() {
        List<String> allPrompts = new ArrayList<>();
        for (int i = 0; i < knownKeys.size(); i++) {
            String key = knownKeys.get(i);
            List<String> moodPrompts = prompts.get(key);
            for (int j = 0; j < moodPrompts.size(); j++) {
                allPrompts.add(moodPrompts.get(j));
            }
        }

        Random random = new Random();
        int index = random.nextInt(allPrompts.size());
        return allPrompts.get(index);
    }

    public String getPromptByMood(String mood) {
        mood = mood.toLowerCase();
        List<String> moodPrompts = prompts.get(mood);

        if (moodPrompts == null || moodPrompts.size() == 0) {
            return "Write what's in your mind.";
        }

        Random random = new Random();
        int index = random.nextInt(moodPrompts.size());
        return moodPrompts.get(index);
    }
}

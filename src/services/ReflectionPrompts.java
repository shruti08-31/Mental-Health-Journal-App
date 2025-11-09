package service;

import java.util.HashMap;
import java.util.Map;

public class ReflectionPrompts {
    private final Map<String, String> store = new HashMap<>();

    public ReflectionPrompts() {
        // Seed with a few combos
        store.put("sad_INFP", "What would bring you comfort right now?");
        store.put("anxious_INFP", "What's worrying you the most at this moment?");
        store.put("happy_ESTJ", "What helped you feel productive today?");
        store.put("neutral_ANY", "How are you feeling today? Tell me more.");
        // Generic fallbacks
        store.put("sad_ANY", "What do you think caused this sadness today?");
        store.put("happy_ANY", "What contributed to your good mood today?");
        store.put("anxious_ANY", "Can you describe what's making you anxious?");
    }

    public String getPrompt(String mood, String personality) {
        String key = mood.toLowerCase() + "_" + (personality == null ? "ANY" : personality);
        if (store.containsKey(key)) return store.get(key);
        String fallback = mood.toLowerCase() + "_ANY";
        return store.getOrDefault(fallback, "How are you feeling today?");
    }
}

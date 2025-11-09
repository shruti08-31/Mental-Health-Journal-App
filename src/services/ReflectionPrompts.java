package services;

import java.util.*;

public class ReflectionPrompts {

    private static final Map<String, String> prompts = new HashMap<>();

    static {
        prompts.put("Happy_INFP", "What’s something you’re grateful for today?");
        prompts.put("SAD_INFP", "What would bring you comfort right now?");
        prompts.put("HAPPY_ESTJ", "What’s your biggest win today?");
        prompts.put("SAD_ESTJ", "What action can you take to lift your mood?");
    }

    public String getPrompt(String mood, String personality) {
        return prompts.getOrDefault(mood + "   " + personality,
                "How are you feeling today about things?");
    }
}

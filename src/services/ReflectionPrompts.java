package services;

public class ReflectionPrompts {
    public String getPrompt(String mood, String personalityType) {
        return switch (mood.toLowerCase()) {
            case "happy" -> "What made you feel happy today?";
            case "sad" -> "What do you think caused your sadness?";
            case "calm" -> "What helped you feel at ease today?";
            case "stressed" -> "What’s been weighing on your mind?";
            default -> "What stands out most about your day?";
        };
    }
}

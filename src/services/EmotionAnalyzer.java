package services;

import model.User;

public class EmotionAnalyzer {

    public String detectMoodFromText(String content) {
        String lower = content.toLowerCase();
        if (lower.contains("happy") || lower.contains("joy") || lower.contains("excited"))
            return "happy";
        if (lower.contains("calm") || lower.contains("relaxed") || lower.contains("peace"))
            return "calm";
        if (lower.contains("sad") || lower.contains("lonely") || lower.contains("cry"))
            return "sad";
        if (lower.contains("stress") || lower.contains("angry") || lower.contains("tired"))
            return "stressed";
        return "neutral";
    }

    public void adjustMoodScore(User user, String mood) {
        int delta = switch (mood.toLowerCase()) {
            case "happy" -> 10;
            case "calm" -> 5;
            case "sad" -> -5;
            case "stressed" -> -10;
            default -> 0;
        };
        int tempScore = user.getMoodScore() + delta;
        int newScore;

        if (tempScore < 0) {
            newScore = 0;
        }
        else if (tempScore > 100) {
            newScore = 100;
        }
        else {
            newScore = tempScore;
        }

        user.setMoodScore(newScore);
    }
}

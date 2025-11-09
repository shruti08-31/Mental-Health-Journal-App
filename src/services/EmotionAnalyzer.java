package services;

import model.User;

import java.time.LocalDate;

public class EmotionAnalyzer {

    /**
     * Update user's mood score and streak based on mood and journal date.
     * This uses simple heuristic scoring:
     * happy -> +1.5, neutral -> +0.5, sad -> -1.0, anxious -> -0.7
     */
    public void updateUserEmotion(User user, String mood) {
        double delta = scoreDeltaForMood(mood);
        user.setMoodScore(user.getMoodScore() + delta);
        updateStreak(user);
    }

    private double scoreDeltaForMood(String mood) {
        switch (mood.toLowerCase()) {
            case "happy": return 1.5;
            case "neutral": return 0.5;
            case "anxious": return -0.7;
            case "sad": return -1.0;
            default: return 0.0;
        }
    }

    private void updateStreak(User user) {
        LocalDate today = LocalDate.now();
        LocalDate last = user.getLastJournalDate();
        if (last == null) {
            user.setCurrentStreak(1);
            user.setLastJournalDate(today);
            return;
        }
        if (last.plusDays(1).equals(today)) {
            user.setCurrentStreak(user.getCurrentStreak() + 1);
        } else if (last.equals(today)) {
            // same day entry doesn't change streak
        } else {
            user.setCurrentStreak(1);
        }
        user.setLastJournalDate(today);
    }

    /**
     * Determine sentiment type by naive keyword matching.
     * Returns "positive","neutral","negative".
     */
    public String analyzeSentiment(String content) {
        String c = content.toLowerCase();
        int positive = 0;
        int negative = 0;
        String[] posWords = {"good","great","happy","joy","love","excited","relieved"};
        String[] negWords = {"sad","angry","hate","lonely","depressed","worried","anxious","stressed","upset"};

        for (String w : posWords) if (c.contains(w)) positive++;
        for (String w : negWords) if (c.contains(w)) negative++;

        if (positive > negative) return "positive";
        if (negative > positive) return "negative";
        return "neutral";
    }
}

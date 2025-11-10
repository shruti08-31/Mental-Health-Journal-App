package services;

import model.User;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmotionAnalyzer {

    public String checkFeelingTone(String text) {
        text = text.toLowerCase();
        if (text.contains("sad") || text.contains("tired") || text.contains("angry")) 
            return "negative";
        if (text.contains("happy") || text.contains("excited") || text.contains("grateful")) 
            return "positive";
        return "neutral";
    }

    public void updateMoodScore(User user, String tone) {
        int score = user.getMoodScore();
        switch (tone) {
            case "positive" -> score += 5;
            case "negative" -> score -= 5;
        }
        int clampedScore = Math.max(0, Math.min(100, score));
        user.setMoodScore(clampedScore);
    }

    public void updateStreak(User user) {
        LocalDate lastDate = user.getLastJournalDate();
        LocalDate now = LocalDate.now();

        if (lastDate == null) {
            user.setStreakCount(1);
        } 
        else {
            long days = ChronoUnit.DAYS.between(lastDate, now);
            if (days == 1)
                user.setStreakCount(user.getStreakCount() + 1);
            else if (days > 1)
                user.setStreakCount(1);
        }
    }
}

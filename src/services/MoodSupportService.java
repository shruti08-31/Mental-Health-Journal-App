package services;

import model.User;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MoodRecommendationService {

    public String giveSupportMessage(String tone) {
        if ("positive".equals(tone)) {
            return "Your positivity is shining through!";
        } 
        else if ("negative".equals(tone)) {
            return "It’s completely okay to feel that way. You’re doing your best.";
        } 
        else {
            return "Thanks for sharing your thoughts today.";
        }
    }

    public String remindUserIfInactive(User user) {
        
        LocalDate lastDate = user.getLastJournalDate(); 

        if (lastDate == null) {
            return "How have you been feeling lately? Want to jot a quick note?";
        }

        long days = ChronoUnit.DAYS.between(lastDate, LocalDate.now());
        if (days >= 3) {
            return "You haven’t written in a while — want to check in?";
        }

        return null;
    }

    public String encourageBasedOnMood(User user) {
        int score = user.getMoodScore();
        if (score > 70) {
            return "Your positivity is shining through!";
        }
        if (score < 40) {
            return "Be gentle with yourself today. Maybe take a short break.";
        }
        return "Keep expressing yourself — you’re doing great!";
    }
}

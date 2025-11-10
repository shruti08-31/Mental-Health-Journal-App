package services;

import model.User;

public class MoodSupportService {

    public String getSupportMessage(String tone) {
        switch (tone.toLowerCase()) {
            case "positive":
                return "Keep spreading positivity today! Maybe share your happiness with someone you care about.";
            case "grateful":
                return "Write down three things you’re thankful for today — gratitude deepens joy.";
            case "motivated":
                return "Use this energy to make progress toward something meaningful! Stay consistent.";
            case "negative":
                return "It’s okay to feel low sometimes. Take a deep breath and be kind to yourself — better days are ahead.";
            case "neutral":
                return "Every day doesn’t have to be perfect. Take a moment to relax and reflect.";
            default:
                return "No matter how you feel today, remember — it’s part of your journey, and you’re growing.";
        }
    }

    public String suggestActivity(User user) {
        int mood = user.getMoodScore();

        if (mood >= 70) {
            return "You seem upbeat! How about going for a walk or calling a friend?";
        } 
        else if (mood >= 40) {
            return "Maybe listen to your favorite song or write about your day.";
        } 
        else {
            return "Try some deep breathing, meditation, or journaling about what’s bothering you.";
        }
    }
}

package service;

import model.User;

public class ProgressEvaluator {

    public String checkProgress(User user) {
        if (user.getStreakCount() >= 7)
            return "🌟 You’ve completed a 7-day mood streak!";
        else if (user.getStreakCount() >= 3)
            return "🌼 You’re building great consistency!";
        return "Keep writing daily — every word helps.";
    }
}

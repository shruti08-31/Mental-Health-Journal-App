package service;

import model.User;

public class GoalTracker {
    private int level = 1;

    public String levelUp(User user) {
        if (user.getMoodScore() > 80 && user.getStreakCount() > 5) {
            level++;
            return " You reached Level " + level + "! Keep the positive energy!";
        }
        return "Stay consistent — you’re getting closer to the next level!";
    }
}

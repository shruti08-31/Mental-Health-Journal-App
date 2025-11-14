package services;

import model.User;

public class ProgressEvaluator {
    public String checkProgress(User user) {
        if (user.getMoodScore() > 80)
            return "You’re in a great emotional zone!";
        if (user.getMoodScore() > 60)
            return "You’re emotionally stable!";
        if (user.getMoodScore() > 40)
            return "A few low moods — keep reflecting!";
        return "Try journaling and resting more!";
    }
}

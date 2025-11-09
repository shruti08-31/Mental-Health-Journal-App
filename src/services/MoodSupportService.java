package services;

import model.User;
import model.JournalEntry;
import java.time.LocalDate;
import java.util.List;

public class MoodSupportService {
    public String giveEmotionalResponse(String mood) {
        if (mood == null) return "Thanks for sharing your thoughts.";

        switch (mood.toLowerCase()) {
            case "sad":
            case "angry":
            case "anxious":
            case "stressed":
                return "It’s completely okay to feel that way. You’re doing your best.";
            case "happy":
            case "excited":
            case "joyful":
                return "Your positivity is shining through today!";
            default:
                return "Thanks for expressing how you feel today.";
        }
    }

    public String gentleReminderIfInactive(User user) {
        if (user == null || user.getLastEntryDate() == null) {
            return "Hey there, how have you been? Would you like to write something today?";
        }

        long daysSinceLastEntry = LocalDate.now().toEpochDay() - user.getLastEntryDate().toEpochDay();

        if (daysSinceLastEntry >= 3) {
            return "It’s been a while since your last entry. Want to jot down a few thoughts today?";
        } else {
            return "";
        }
    }

    public String giveEncouragement(User user, int previousScore, int currentScore) {
        if (user == null) 
            return "";

        if (currentScore > previousScore) {
            return "You’re doing great! Your emotional energy seems to be lifting.";
        } 
        else if (currentScore < previousScore) {
            return "Be gentle with yourself today. Maybe take a short break or deep breath.";
        } 
        else {
            return "Keep going — steady progress matters too!";
        }
    }
    public String checkRepeatedMoodPattern(List<JournalEntry> recentEntries) {
        if (recentEntries == null || recentEntries.size() < 3) {
            return "";
        }
        String latestMood = recentEntries.get(recentEntries.size() - 1).getMood();
        int repeatCount = 1;

        for (int i = recentEntries.size() - 2; i >= 0; i--) {
            String mood = recentEntries.get(i).getMood();
            if (mood != null && mood.equalsIgnoreCase(latestMood)) {
                repeatCount++;
            } 
            else {
                break;
            }
        }

        if (repeatCount >= 3) {
            return "You’ve been feeling " + latestMood.toLowerCase() +
                   " lately — want to explore what might be causing it?";
        }
        return "";
    }
    public String respondAfterWriting(User user, String mood, int previousScore, int currentScore) {
        String message = giveEmotionalResponse(mood);
        message += "\n" + giveEncouragement(user, previousScore, currentScore);
        return message;
    }
}

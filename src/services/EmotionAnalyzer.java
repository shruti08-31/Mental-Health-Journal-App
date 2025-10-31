package service;

public class EmotionAnalyzer {

    //calculate emotion 
    public int getEmotionScore(String notes) {
        String text = notes.toLowerCase();
        int score = 0;
        if (text.contains("happy") || text.contains("grateful") || text.contains("motivated") || text.contains("calm")) {
            score = score + 2;
        }
        if (text.contains("neutral")) {
            score = score + 1;
        }
        if (text.contains("sad") || text.contains("lonely") || text.contains("angry") ||
            text.contains("frustrated") || text.contains("jealous") || text.contains("anxious") ||
            text.contains("stressed") || text.contains("nervous") || text.contains("tired")) {
            score = score - 2;
        }
        if (text.contains("bored") || text.contains("confused") || text.contains("overwhelmed")) {
            score = score - 1;
        }

        return score;
    }

    //detect emotion
    public String detectEmotion(String notes) {
        int score = getEmotionScore(notes);

        if (score > 1) {
            return "Positive";
        } else if (score < -1) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}

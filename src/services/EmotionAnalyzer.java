
package services;

import model.User;

public class EmotionAnalyzer {
   public EmotionAnalyzer() {
   }

   public String detectMoodFromText(String content) {
      String lower = content.toLowerCase();
      if (!lower.contains("happy") && !lower.contains("joy") && !lower.contains("excited")) {
         if (!lower.contains("calm") && !lower.contains("relaxed") && !lower.contains("peace")) {
            if (!lower.contains("sad") && !lower.contains("lonely") && !lower.contains("cry")) {
               return !lower.contains("stress") && !lower.contains("angry") && !lower.contains("tired") ? "neutral" : "stressed";
            } else {
               return "sad";
            }
         } else {
            return "calm";
         }
      } else {
         return "happy";
      }
   }

   public void adjustMoodScore(User user, String mood) {
      byte var10000;
      switch (mood.toLowerCase()) {
         case "happy":
            var10000 = 10;
            break;
         case "calm":
            var10000 = 5;
            break;
         case "sad":
            var10000 = -5;
            break;
         case "stressed":
            var10000 = -10;
            break;
         default:
            var10000 = 0;
      }

      int delta = var10000;
      int tempScore = user.getMoodScore() + delta;
      if (tempScore < 0) {
         newScore = 0;
      } else if (tempScore > 100) {
         newScore = 100;
      } else {
         newScore = tempScore;
      }

      user.setMoodScore(newScore);
   }
}

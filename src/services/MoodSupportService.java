// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import model.User;

public class MoodSupportService {
   public MoodSupportService() {
   }

   public String getSupportMessage(String tone) {
      if (tone == null) {
         return this.defaultMessage();
      } else {
         switch (tone.toLowerCase()) {
            case "positive":
               return "Keep spreading positivity today! Maybe share your happiness with someone you care about.";
            case "grateful":
               return "Write down three things you’re thankful for today — gratitude deepens joy.";
            case "motivated":
               return "Use this energy to make progress toward something meaningful!";
            case "negative":
               return "It’s okay to feel low sometimes. Take a deep breath and be kind to yourself.";
            case "neutral":
               return "Every day doesn’t have to be perfect. Take a moment to relax and reflect.";
            default:
               return this.defaultMessage();
         }
      }
   }

   public String suggestActivity(User user) {
      if (user == null) {
         return "Try a short walk or a breathing exercise.";
      } else {
         int mood = user.getMoodScore();
         if (mood >= 70) {
            return "You seem upbeat! How about going for a walk or calling a friend?";
         } else {
            return mood >= 40 ? "Maybe listen to your favorite song or write about your day." : "Try some deep breathing, a short walk, or journaling about what's bothering you.";
         }
      }
   }

   private String defaultMessage() {
      return "No matter how you feel today, remember — it's part of your journey.";
   }
}

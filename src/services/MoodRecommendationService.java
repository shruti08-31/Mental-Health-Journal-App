// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

public class MoodRecommendationService {
   public MoodRecommendationService() {
   }

   public String generateResponse(String mood) {
      String var10000;
      switch (mood.toLowerCase()) {
         case "happy":
            var10000 = "Keep doing what makes you smile!";
            break;
         case "calm":
            var10000 = " Stay grounded and enjoy your peace.";
            break;
         case "sad":
            var10000 = " It’s okay to feel sad. Let yourself process it.";
            break;
         case "stressed":
            var10000 = " Try a breathing exercise or short walk.";
            break;
         default:
            var10000 = " Stay mindful and notice how you feel.";
      }

      return var10000;
   }
}

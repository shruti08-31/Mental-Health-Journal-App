// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Goal;

public class GoalRecommender {
   public GoalRecommender() {
   }

   public List<Goal> recommendGoals(String mood) {
      List<Goal> goals = new ArrayList();
      mood = mood.toLowerCase();
      if (mood.contains("happy")) {
         goals.add(new Goal(1, "Share Your Joy", "Call a friend or family member to spread positivity."));
         goals.add(new Goal(2, "Capture the Moment", "Write a gratitude note or take a photo to remember the day."));
      } else if (!mood.contains("sad") && !mood.contains("depressed")) {
         if (mood.contains("stressed")) {
            goals.add(new Goal(5, "Meditate for 10 Minutes", "Try breathing exercises or guided meditation."));
            goals.add(new Goal(6, "Organize Your Space", "Clean your room or workspace to feel calmer."));
         } else if (mood.contains("angry")) {
            goals.add(new Goal(7, "Listen to Calm Music", "Relax with slow or instrumental tracks."));
            goals.add(new Goal(8, "Do Physical Activity", "Channel your energy into exercise or stretching."));
         } else if (mood.contains("anxious")) {
            goals.add(new Goal(9, "Write 3 Positives", "Note three things you’re grateful for today."));
            goals.add(new Goal(10, "Limit Screen Time", "Avoid social media for a few hours."));
         } else if (mood.contains("tired")) {
            goals.add(new Goal(11, "Take a Short Nap", "Rest for 20–30 minutes to recharge."));
            goals.add(new Goal(12, "Drink Water", "Hydrate and avoid caffeine late in the day."));
         } else {
            goals.add(new Goal(13, "Try Something New", "Do a small creative activity or hobby."));
            goals.add(new Goal(14, "Reflect on Goals", "Think about what small step you can take today."));
         }
      } else {
         goals.add(new Goal(3, "Take a Nature Walk", "Go for a short walk outside to refresh your mind."));
         goals.add(new Goal(4, "Write Feelings Down", "Journal your emotions to understand them better."));
      }

      return goals;
   }

   public void displayRecommendations(List<Goal> goals) {
      System.out.println("\nRecommended Goals for You:");
      Iterator var2 = goals.iterator();

      while(var2.hasNext()) {
         Goal g = (Goal)var2.next();
         PrintStream var10000 = System.out;
         String var10001 = g.getTitle();
         var10000.println("- " + var10001 + ": " + g.getDescription());
      }

   }
}

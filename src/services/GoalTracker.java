// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.Goal;

public class GoalTracker {
   private GoalRecommender recommender = new GoalRecommender();
   private Scanner sc;

   public GoalTracker() {
      this.sc = new Scanner(System.in);
   }

   public void trackGoals(String mood) {
      List<Goal> goals = this.recommender.recommendGoals(mood);
      System.out.println("\nBased on your mood, here are your goals:");
      Iterator var3 = goals.iterator();

      PrintStream var10000;
      String var10001;
      Goal g;
      while(var3.hasNext()) {
         g = (Goal)var3.next();
         var10000 = System.out;
         var10001 = g.getTitle();
         var10000.println("- " + var10001 + ": " + g.getDescription());
      }

      System.out.println("\nHave you completed these goals? (yes/no)");
      var3 = goals.iterator();

      while(var3.hasNext()) {
         g = (Goal)var3.next();
         System.out.print(g.getTitle() + " → ");
         String ans = this.sc.nextLine().trim().toLowerCase();
         if (ans.equals("yes")) {
            g.markCompleted();
         }
      }

      System.out.println("\nGoal Progress:");
      var3 = goals.iterator();

      while(var3.hasNext()) {
         g = (Goal)var3.next();
         var10000 = System.out;
         var10001 = g.getTitle();
         var10000.println(var10001 + " - " + (g.isCompleted() ? "Completed" : "Pending"));
      }

   }
}

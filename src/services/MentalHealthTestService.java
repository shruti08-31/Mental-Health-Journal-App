// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MentalHealthTestService {
   private Scanner sc;
   private Map<String, List<String>> testMap;

   public MentalHealthTestService() {
      this.sc = new Scanner(System.in);
      this.testMap = new HashMap();
      this.testMap.put("adhd", List.of("Do you find it hard to focus?", "Do you act without thinking?", "Do you get easily distracted?"));
      this.testMap.put("anxiety", List.of("Do you feel nervous often?", "Do you worry too much?", "Do you find it hard to relax?"));
      this.testMap.put("bipolar", List.of("Do you have sudden mood changes?", "Do you feel extremely energetic sometimes?", "Do you also feel very low sometimes?"));
      this.testMap.put("depression", List.of("Do you feel sad or hopeless?", "Have you lost interest in daily activities?", "Do you feel tired most of the time?"));
      this.testMap.put("autism", List.of("Do you find it hard to socialize?", "Do you dislike changes in routine?", "Do you notice small details others miss?"));
      this.testMap.put("ocd", List.of("Do you have unwanted repeated thoughts?", "Do you perform certain actions again and again?", "Do you check things repeatedly?"));
      this.testMap.put("ptsd", List.of("Do you have flashbacks of bad events?", "Do you avoid reminders of trauma?", "Do you feel easily startled?"));
      this.testMap.put("stress", List.of("Do you often feel overwhelmed?", "Do you find it hard to concentrate?", "Do you have trouble sleeping due to worries?"));
   }

   public void startTest() {
      System.out.println("Available Tests: " + String.join(", ", this.testMap.keySet()));
      System.out.print("\nEnter test name: ");
      String test = this.sc.nextLine().trim().toLowerCase();
      List<String> questions = (List)this.testMap.get(test);
      if (questions == null) {
         System.out.println("Invalid test name!");
      } else {
         System.out.println("\nRate each question (0=Never, 1=Sometimes, 2=Often, 3=Always)\n");
         int total = 0;

         for(Iterator var4 = questions.iterator(); var4.hasNext(); total += this.getAnswer()) {
            String q = (String)var4.next();
            System.out.print(q + " → ");
         }

         System.out.println("\n--- " + test.toUpperCase() + " TEST RESULT ---");
         if (total <= 3) {
            System.out.println("Low " + test + " signs");
         } else if (total <= 6) {
            System.out.println("Moderate " + test + " signs");
         } else {
            System.out.println("High " + test + " signs");
         }

      }
   }

   private int getAnswer() {
      while(true) {
         try {
            int ans = Integer.parseInt(this.sc.nextLine().trim());
            if (ans >= 0 && ans <= 3) {
               return ans;
            }
         } catch (Exception var2) {
         }

         System.out.print("Enter a valid number (0–3): ");
      }
   }
}

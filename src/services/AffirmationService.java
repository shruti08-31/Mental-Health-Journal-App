// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AffirmationService {
   private List<String> affirmations = new ArrayList();

   public AffirmationService() {
      this.affirmations.add("You are enough.");
      this.affirmations.add("You’re doing your best.");
      this.affirmations.add("You deserve peace.");
      this.affirmations.add("You are growing every day.");
      this.affirmations.add("You have the power to create change.");
      this.affirmations.add("Your efforts will pay off.");
      this.affirmations.add("You are capable of amazing things.");
      this.affirmations.add("Every day is a fresh start.");
      this.affirmations.add("You are stronger than you think.");
      this.affirmations.add("Keep believing in yourself.");
      this.affirmations.add("You bring value to the world.");
      this.affirmations.add("Your hard work makes a difference.");
      this.affirmations.add("It’s okay to take a break and breathe.");
      this.affirmations.add("You are learning and improving daily.");
      this.affirmations.add("Your dreams are worth chasing.");
   }

   public String getDailyAffirmation() {
      Random rand = new Random();
      int index = rand.nextInt(this.affirmations.size());
      return (String)this.affirmations.get(index);
   }
}

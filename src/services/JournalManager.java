// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package services;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.JournalEntry;
import model.Tag;
import model.User;

public class JournalManager extends TagManager {
   private List<JournalEntry> entries = new ArrayList();
   private SleepTracker sleepTracker = new SleepTracker();
   private PersonalityTestService personalityTestService = new PersonalityTestService();
   private Map<User, String[]> userPersonalityMap = new HashMap();

   public JournalManager() {
   }

   public JournalEntry createEntry(User user, String mood, String content, String intensity) {
      JournalEntry entry = new JournalEntry(mood, content, intensity);
      Tag tag = this.createTag(mood);
      entry.setTag(tag);
      this.entries.add(entry);
      user.addEntry(entry);
      System.out.println("Journal Entry Created Successfully!");
      System.out.println("Mood: " + mood);
      System.out.println("Intensity: " + intensity);
      System.out.println("Tag: " + tag.getTagText());
      return entry;
   }

   public List<JournalEntry> getEntries() {
      return this.entries;
   }

   public void viewProgress(User user) {
      if (user.getEntries().isEmpty()) {
         System.out.println("No entries yet!");
      } else {
         System.out.println("\nMood Progress for " + user.getName() + ":");
         Iterator var2 = user.getEntries().iterator();

         while(var2.hasNext()) {
            JournalEntry entry = (JournalEntry)var2.next();
            System.out.println(" " + String.valueOf(entry));
         }

      }
   }

   public void conductPersonalityCheck(User user) {
      System.out.println("\nStarting personality test for " + user.getName() + "...");
      String[] result = this.personalityTestService.startTest();
      this.userPersonalityMap.put(user, result);
      System.out.println("\nPersonality Analysis Complete!");
      System.out.println("Personality Type: " + result[0]);
      System.out.println("Description: " + result[1]);
   }

   public void showAllPersonalities() {
      if (this.userPersonalityMap.isEmpty()) {
         System.out.println("No personality data yet!");
      } else {
         System.out.println("\nPersonality Summary:");
         Iterator var1 = this.userPersonalityMap.entrySet().iterator();

         while(var1.hasNext()) {
            Map.Entry<User, String[]> entry = (Map.Entry)var1.next();
            String[] data = (String[])entry.getValue();
            PrintStream var10000 = System.out;
            String var10001 = ((User)entry.getKey()).getName();
            var10000.println(var10001 + " → " + data[0] + " (" + data[1] + ")");
         }

      }
   }

   public SleepTracker getSleepTracker() {
      return this.sleepTracker;
   }
}

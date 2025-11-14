package main;
import model.*;
import services.*;
import java.util.*;
public class MainApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, User> userDatabase = new HashMap<>();
    private static final Map<String, String> userPasswords = new HashMap<>();

    // services
    private static final JournalManager journalManager = new JournalManager();
    private static final EmotionAnalyzer emotionAnalyzer = new EmotionAnalyzer();
    private static final ReflectionPrompts reflectionPrompts = new ReflectionPrompts();
    private static final GoalTracker goalTracker = new GoalTracker();
    private static final MoodTrendAnalyzer trendAnalyzer = new MoodTrendAnalyzer();
    private static final MoodSupportService moodSupportService = new MoodSupportService();
    private static final MoodRecommendationService moodRecommendationService = new MoodRecommendationService();
    private static final MentalHealthTestService mentalHealthTestService = new MentalHealthTestService();
    private static final QuoteService quoteService = new QuoteService();
    private static final ProgressEvaluator progressEvaluator = new ProgressEvaluator();

    public static void main(String[] args) {
        System.out.println("welcome");

        User currentUser = loginOrSignup();
        if (currentUser == null)
            return;

        boolean e = false;
        while (!e) {
            System.out.println("\nMain menu");
            System.out.println("1. Make a Journal Entry");
            System.out.println("2. Log Sleep Hours");
            System.out.println("3. Take a Mental Health Test");
            System.out.println("4. Get Goal Recommendations");
            System.out.println("5. Analyze Mood Trends");
            System.out.println("6. View Progress Summary");
            System.out.println("7. View Daily Affirmation & Quote");
            System.out.println("8. Show Personality Summary");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

        System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                makeJournalEntry(currentUser);
            }
            else if (choice.equals("2")) {
                logSleep(currentUser);
            }
            else if (choice.equals("3")) {
                mentalHealthTestService.startTest();
            }
            else if (choice.equals("4")) {
                String mood;
                if (currentUser.getLastEntry() != null) {
                    JournalEntry jn =currentUser.getLastEntry();
                    mood = jn.getMood();
                }
                else {
                    mood = "neutral";
                }

                goalTracker.trackGoals(mood);
            }
            else if (choice.equals("5")) {
                analyzeTrends(currentUser);
            }
            else if (choice.equals("6")) {
                viewProgress(currentUser);
            }
            else if (choice.equals("7")) {
                dailyInspiration();
            }
            else if (choice.equals("8")) {
                journalManager.showAllPersonalities();
            }
            else if (choice.equals("9")) {
                System.out.println("Goodbye, " + currentUser.getName() + "   Stay positive");
                e = true;
            }
            else {
                System.out.println("Invalid choice, please try again.");
            }

        }
    }

    private static User loginOrSignup() {
        System.out.print("\nEnter username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String password = sc.nextLine().trim();

        if (userDatabase.containsKey(username)) {
            //existing user
            if (userPasswords.get(username).equals(password)) {
                System.out.println("\nWelcome back, " + username + "!");
                return userDatabase.get(username);
            } else {
                System.out.println("incorrect password");
                return null;
            }
        } else {
            //new user
            System.out.print("User not found. Do you want to sign up? (yes/no): ");
            String ans = sc.nextLine().trim().toLowerCase();
            if (!ans.equals("yes"))
                return null;

            User newUser = new User(username);
            userDatabase.put(username, newUser);
            userPasswords.put(username, password);
            journalManager.conductPersonalityCheck(newUser);

            System.out.println("\nAccount created.\n Welcome, " + username + " ");
            return newUser;
        }
    }

    private static void makeJournalEntry(User user) {
        System.out.print("\nHow are you feeling today? (happy/sad/calm/stressed/etc): ");
        String mood = sc.nextLine().trim().toLowerCase();

        String prompt = reflectionPrompts.getPrompt(mood, "");
        System.out.println(prompt);
        System.out.print("    ");
        String reflection = sc.nextLine();

        String content = reflection; // treat reflection as journal content

        String intensity = String.valueOf(getIntensity());
        journalManager.createEntry(user, mood, content, intensity);

        // Adjust user mood score
        emotionAnalyzer.adjustMoodScore(user, mood);

        System.out.println("\nJournal entry saved!");
        String gr = moodRecommendationService.generateResponse(mood);
        System.out.println(gr);
        String sa = moodSupportService.suggestActivity(user);
        System.out.println(sa);
    }

    private static int getIntensity() {
        System.out.print("On a scale of 1–10, how strong was this mood? ");
        while (true) {
            try {
                String input = sc.nextLine();
                String trimmedInput = input.trim();
                int val = Integer.parseInt(trimmedInput);
                if (val >= 1 && val <= 10)
                    return val;
            }
            catch (Exception ignored) {

            }
            System.out.print("Enter a valid number (1–10): ");
        }
    }
    private static void logSleep(User user) {
        System.out.print("\nHow many hours did you sleep last night? ");
        try {
            String input = sc.nextLine();
            String trimmedInput = input.trim();
            double hours = Double.parseDouble(trimmedInput);

            SleepTracker sp =journalManager.getSleepTracker();
            sp.logSleepHours(hours);
            System.out.println(sp.getAdvice());
        }
        catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    // analyze mood
    private static void analyzeTrends(User user) {
        MoodTrendAnalyzer md =  new MoodTrendAnalyzer();
        LinkedList<JournalEntry> l= user.getEntries();
        String trend =md.analyzeTrend(l);
        if (trend.isEmpty())
            System.out.println("Not enough data for trend analysis.");
        else
            System.out.println(trend);
    }

    // view progress
    private static void viewProgress(User user) {
        journalManager.viewProgress(user);
        String s = progressEvaluator.checkProgress(user);
        System.out.println(s);
    }

    //qoutes recommendation
    private static void dailyInspiration() {
        AffirmationService af =new AffirmationService();
        System.out.println("\nDaily Affirmation: " + af.getDailyAffirmation());
        System.out.println("Quote of the Day: " + quoteService.getQuoteOfTheDay());
    }
}

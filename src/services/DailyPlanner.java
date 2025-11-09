package services;

public class DailyPlanner {
    public String suggestActivity(String day, String moodTrend) {
        if (moodTrend.equals("low")) {
            return "You tend to feel low on " + day + ". Plan a small self-care activity!";
        }
        return "Looks like " + day + " is your positive day! Keep it going!";
    }
}

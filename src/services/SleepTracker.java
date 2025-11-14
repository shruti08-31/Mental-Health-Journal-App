package services;

public class SleepTracker {
    private double lastSleepHours = 0;

    public void logSleepHours(double hours) {
        this.lastSleepHours = hours;
    }

    public String getAdvice() {
        if (lastSleepHours < 5)
            return "You seem sleep-deprived. Try to rest more tonight";
        if (lastSleepHours < 7)
            return " Decent sleep, but aim for 7–8 hours for best mood balance.";
        if (lastSleepHours <= 9)
            return " Great sleep! Your mind will thank you.";
        return " Overslept? Try to keep a regular sleep schedule.";
    }
}

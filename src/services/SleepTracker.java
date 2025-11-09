package service;

public class SleepTracker {
    private int lastNightSleepHours;

    public void logSleep(int hours) {
        this.lastNightSleepHours = hours;
    }

    public String giveSleepAdvice() {
        if (lastNightSleepHours < 6)
            return "You slept only " + lastNightSleepHours + " hrs — try sleeping a bit earlier tonight.";
        else
            return "Your sleep looks balanced — keep it up!";
    }
}

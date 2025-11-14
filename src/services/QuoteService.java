package services;

import java.util.List;
import java.util.Random;

public class QuoteService {
    private final List<String> quotes = List.of(
            "Every day is a fresh start.",
            "You are stronger than you think.",
            "Breathe. It’s just a bad day, not a bad life.",
            "Gratitude turns what we have into enough.",
            "Progress, not perfection.",
            "Small steps every day lead to big results.",
            "You don’t have to be perfect to be amazing.",
            "You’ve survived 100% of your worst days.",
            "Happiness is not something ready-made. It comes from your own actions.",
            "Be gentle with yourself. You’re doing the best you can."
    );

    public String getQuoteOfTheDay() {
        Random random = new Random();
        int index = random.nextInt(quotes.size());
        String randomQuote = quotes.get(index);
        return randomQuote;

    }
}


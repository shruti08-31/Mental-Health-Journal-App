package service;

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
        "Let your smile change the world, but don’t let the world change your smile.",
        "Be gentle with yourself. You’re doing the best you can.",
        "You are enough, just as you are.",
        "Take time to make your soul happy.",
        "Healing is not linear.",
        "Rest is productive too.",
        "Your feelings are valid.",
        "The present moment is all you ever have.",
        "You owe yourself the love you so freely give others.",
        "Peace begins with a deep breath.",
        "Self-care is giving the world the best of you, not what’s left of you.",

        // 💪 Resilience & Growth
        "Fall seven times, stand up eight.",
        "Difficult roads often lead to beautiful destinations.",
        "Storms make trees take deeper roots.",
        "Every setback is a setup for a comeback.",
        "Growth is uncomfortable because you’ve never been here before.",
        "Don’t be afraid to start over. It’s a chance to build something better.",
        "The comeback is always stronger than the setback.",
        "Change is hard at first, messy in the middle, and gorgeous at the end.",
        "You don’t have to have it all figured out to move forward.",
        "Even the darkest night will end and the sun will rise.",
        "Appreciate the little things, for one day you may look back and realize they were the big things.",
        "Gratitude unlocks the fullness of life.",
        "A calm mind brings inner strength.",
        "Peace is not the absence of chaos, but the presence of tranquility within it.",
        "Smile more. Worry less.",
        "Today, I choose peace over worry.",
        "Let go of what you can’t control and focus on what you can.",
        "Kindness begins with the understanding that we all struggle.",
        "When you can’t find the sunshine, be the sunshine.",
        "Take a deep breath and remind yourself that you are in control of your own happiness."
    );

    public String getQuoteOfTheDay() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}

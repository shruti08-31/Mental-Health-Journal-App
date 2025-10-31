package services;

public class MoodRecommendationService {

    public String getRecommendation(String mood) {
        switch (mood.toLowerCase()) {
          
            case "happy":
                return "Keep spreading positivity today! Maybe share your happiness with someone you care about.";
            
            case "grateful":
                return "Write down three things you’re thankful for today — gratitude deepens joy.";
            case "motivated":
                return "Use this energy to make progress toward something meaningful! Stay consistent.";
            case "calm":
                return "Enjoy the peace you feel — take a mindful walk or simply rest in the moment.";
            case "sad":
                return "Allow yourself to feel it. Write about what’s hurting or talk to someone who listens with care.";
            case "lonely":
                return "Reach out to a loved one or spend time doing something that brings you comfort.";
            case "anxious":
                return "Take slow, deep breaths. Ground yourself by focusing on what you can see and touch.";
            case "stressed":
                return "Try a 5-minute meditation or step away from screens. Remember — you can handle this.";
            case "overwhelmed":
                return "Pause and take one thing at a time. Even small progress is progress.";
            case "tired":
                return "Take a short nap, drink some water, and stretch your body — rest is part of productivity.";
            case "angry":
                return "Breathe deeply and give yourself space. A walk or calm music might help you cool down.";
            case "frustrated":
                return "Step away for a moment. Reflect before reacting — calm clarity brings better solutions.";
            case "jealous":
                return "Shift focus to your own journey — your growth is unique and valuable.";
            case "bored":
                return "Try something creative — draw, cook, or learn a new skill online.";
            case "confused":
                return "Write down what’s bothering you — clarity often comes through reflection.";
            case "neutral":
                return "Sometimes steady and neutral is peaceful — enjoy the calm balance.";
            case "nervous":
                return "You’re braver than you think. Focus on breathing slowly — calm confidence grows inside you.";
            default:
                return "Be kind to yourself — whatever you’re feeling is valid. Take a breath and do something that nurtures you.";
        }
    }
}

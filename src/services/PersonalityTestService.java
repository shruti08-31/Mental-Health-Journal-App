package services;

import java.util.*;

public class PersonalityTestService {
    private final Map<Integer, String[]> questions = new LinkedHashMap<>();
    public PersonalityTestService() {
        questions.put(1, new String[]{"Do you prefer to focus on the outer world or your inner world? (outer/inner)"});
        questions.put(2, new String[]{"Do you prefer to focus on basic information or interpret meaning? (info/meaning)"});
        questions.put(3, new String[]{"Do you prefer to make decisions based on logic or people? (logic/people)"});
        questions.put(4, new String[]{"Do you prefer a planned lifestyle or spontaneous? (planned/spontaneous)"});
    }

    public String runSampleTest(List<String> answers) {
        StringBuilder sb = new StringBuilder();
        if (answers.size() < 4) {
            return "INFP";
        }
        return sb.toString();
    }
}

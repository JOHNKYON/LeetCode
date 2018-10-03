package questions.leetcode843;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        int rand = new Random().nextInt(wordlist.length);
        String guess = wordlist[rand];

        int match = master.guess(guess);

        if (match == wordlist[0].length())
            return;

        List<String> candidates = new ArrayList<>();

        for (String s : wordlist) {
            if (!s.equals(guess) && countMatch(s, guess) == match)
                candidates.add(s);
        }

        String[] new_word_list = candidates.toArray(new String[candidates.size()]);
        findSecretWord(new_word_list, master);
    }

    private int countMatch(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                count++;
        }
        return count;
    }

    private class Master{
        int guess(String s) {
            return 0;
        }
    }
}

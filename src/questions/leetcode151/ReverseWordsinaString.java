package questions.leetcode151;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String word: words) {
            if (!word.equals(""))
                list.add(word);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i>=0; i--){
            sb.append(list.get(i));
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}

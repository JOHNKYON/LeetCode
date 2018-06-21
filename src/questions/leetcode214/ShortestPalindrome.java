package questions.leetcode214;

public class ShortestPalindrome {
    public String shortestPalidrome(String s){
        char[] origin_s = s.toCharArray();
        char[] str = new char[2*(origin_s.length+1)];
        str[0] = '$';
        str[1] = '#';
        int index = 2;

        for (char ch : origin_s){
            str[index] = ch;
            str[index+1] = '#';
            index += 2;
        }

        index = str.length/2;
        int range = 0;
        while (index >= 2){
            while (str[index-range] == '$'|| str[index-range] == str[index+range]){
                if (str[index-range] == '$') return build(index, str);
                else range += 1;
            }
            index -= 1;
            range = 0;
        }
        return build(index, str);
    }

    private String build(int index, char[] str){
        int length = ((str.length-index)/2) * 2;
        char[] s;

        if (str[index] == '#'){
            s = new char[length];

            int p = length/2;
            while (p<length){
                s[p] = s[s.length-p-1] = str[index+1];
                index += 2;
                p += 1;
            }
        }else {
            length -= 1;
            s = new char[length];

            int p = length/2;
            while (p<length){
                s[p] = s[s.length-p-1] = str[index];
                index += 2;
                p+=1;
            }
        }
        return new String(s);
    }
}

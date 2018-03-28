import questions.regularExpressionMatching.RegularExpressionMatching;

public class Main {
    public static void main(String[] args){
        RegularExpressionMatching method = new RegularExpressionMatching();
        String s = "aab";
        String p = "c*a*b";
        System.out.print(method.isMatch(s, p));
    }

}

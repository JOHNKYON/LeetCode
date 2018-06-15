package questions.codility;

public class NumberShuffle {
    public int solution(int A){
        // Convert to string
        String A_str = (new Integer(A)).toString();
        char[] chararr = A_str.toCharArray();

        // Shuffle
        int i = 0, j = A_str.length()-1;
        while (i < j){
            chararr[i*2] = A_str.charAt(i);
            chararr[i*2+1] = A_str.charAt(j);
            i++;
            j--;
        }
        // When length of A is odd.
        if (i == j){chararr[i*2] = A_str.charAt(i);}

        // Parse
        return Integer.parseInt(new String(chararr));
    }
}

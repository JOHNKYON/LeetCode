package questions.zigZagConversion;

/**
 * Created by JOHNKYON on 2018/3/20.
 * This is a solution to LeetCode Questions.
 */
public class ZigZagConversion {
//    TODO:Finish the math calculation of the index.

    public String ZigZagConversion(String s, int nRows){
        char[] sOrigin = s.toCharArray();
        char[] sNew = new char[sOrigin.length];
        int setIndex = -1;
        int bias = -1;
        int newIndex = -1;

        int setNum = s.length()/(2 * nRows - 1);
        int tail = s.length()%(2 * nRows - 1);
        int newRowIndex = -1;

        for (int i = 0; i < sOrigin.length; i++){
            /*Split the characters into (Length)/(2n-1) sets,
            * the position of each character in the new string is
            * denoted by it's index and bias*/
            setIndex = i / ( 2 * nRows - 2) + 1;
            bias = i % ( 2 * nRows - 2);
            if (0 == bias){setIndex -= 1;}

            if (bias <= nRows){newRowIndex = bias;}
            else {newRowIndex = 2*nRows - bias;}
            if (1 == newRowIndex) { newIndex = setNum;}
            else {
                newIndex = setNum + 2 * setNum * (newRowIndex - 2);

            }
        }
    }
}

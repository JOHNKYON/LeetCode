package questions.zigZagConversion;

/**
 * Created by JOHNKYON on 2018/3/20.
 * This is a solution to LeetCode Questions.
 */
public class ZigZagConversion {

    public String ZigZagConversion(String s, int numRows){
        char[] sNew = new char[s.length()];
        int setIndex = -1;
        int bias = -1;
        int newIndex = -1;

        if (1 == numRows){return s;}

        int setNum = s.length()/(2 * numRows - 2);
        int tail = s.length()%(2 * numRows - 2);
        int newRowIndex = -1;

        for (int i = 0; i < s.length(); i++){
            /*Split the characters into (Length)/(2n-1) sets,
            * the position of each character in the new string is
            * denoted by it's index and bias*/
            setIndex = (i / ( 2 * numRows - 2)) + 1;
            bias = (i % ( 2 * numRows - 2)) + 1;
//            if (0 == bias){setIndex -= 1;}

            if (bias <= numRows){newRowIndex = bias;}
            else {newRowIndex = 2*numRows - bias;}
            if (1 == newRowIndex) { newIndex = setIndex;}
            else {
//                Calculate the index without considering the tail
                newIndex = setNum + 2 * setNum * (newRowIndex - 2);

                if (newRowIndex == numRows) {newIndex += setIndex;}       //At the last row
                else {
                    newIndex += 2*setIndex;
                    if (bias < numRows){
                        --newIndex;
                    }
                }
//                Consider the tail
                if (newRowIndex > tail){ newIndex += tail;}
                else {newIndex += newRowIndex - 1;}
                if (newRowIndex > 2*numRows - tail){
                    newIndex += newRowIndex + tail - 2*numRows;
                }
            }
            sNew[newIndex-1] = s.charAt(i);
        }
        return new String(sNew);
    }
}

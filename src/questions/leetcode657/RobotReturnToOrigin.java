package questions.leetcode657;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizon = 0;

        for (char c: moves.toCharArray()){
            if (c == 'U')
                horizon++;
            if (c == 'D')
                horizon--;
            if (c == 'R')
                vertical++;
            if (c == 'L')
                vertical--;
        }
        return (vertical == 0 && horizon == 0);
    }
}

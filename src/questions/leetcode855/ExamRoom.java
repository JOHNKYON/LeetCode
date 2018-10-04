package questions.leetcode855;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamRoom {
    int len;
    List<Integer> seats;

    public ExamRoom(int N) {
        len = N;
        seats = new ArrayList<>();
    }

    public int seat() {
        if (seats.size() == 0) {
            seats.add(0);
            return 0;
        }

        int max = -1;
        int left = 0;
        int seat = 0;
        int insert_position = 0;

        if (seats.get(0) != 0) {
            max = seats.get(0) - 1;
            left = seats.get(0);
            seat = 0;
        }

        for (int i=0; i<seats.size(); i++) {
            int curr = seats.get(i);
            if ((max == -1 || (curr - left - 2) / 2 > max) && curr > left+1) {
                insert_position = i;
                max = (curr - left - 2) / 2;
                seat = (left + curr) / 2;
            }
            left = curr;
        }

        if (seats.get(seats.size()-1) != len - 1) {
            if (len - 1 - left - 1 > max) {
                seat = len-1;
                insert_position = seats.size();
            }
        }

        seats.add(insert_position, seat);
        return seat;
    }

    public void leave(int p) {
        int pos = Collections.binarySearch(seats, p);
        seats.remove(pos);
    }
}

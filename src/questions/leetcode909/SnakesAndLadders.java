package questions.leetcode909;

import java.util.*;

public class SnakesAndLadders {
    HashSet<Integer> seen;
    Queue<Integer> queue;
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return -1;

        int n = board.length;
        seen = new HashSet<>();
        queue = new LinkedList<>();

        seen.add(1);
        queue.add(1);
        int step = 0;
        int waiting = 1;
        while(!queue.isEmpty()) {
            if (waiting == 0) {
                waiting = queue.size();
                step++;
            }
            int curr = queue.poll();
            if (curr == n * n)
                return step;
            waiting--;

            for (int i=curr+1; i<=curr+6 && i <= n * n;i++) {
                int num = i;
                int[] add = numToAddress(num, n, n);
                int r = add[0], c = add[1];
                if (board[r][c] != -1) {
                    num = board[r][c];
                }
                if (!seen.contains(num)) {
                    queue.add(num);
                    seen.add(num);
                }
            }
        }

        return -1;

    }

    private int[] numToAddress(int x, int r, int c) {
        int[] address = new int[2];
        address[0] = (r - 1) - ((x - 1) / c);
        address[1] = (x - 1) % c;
        if ((address[0] & 1) != ((r-1) & 1)) {
            address[1] = c - 1 - address[1];
        }

        return address;
    }

    private int addressToNum(int[] address, int r, int c) {
        int x = (r - 1 - address[0]) * 6;
        if ((address[0] & 1) != ((r-1) & 1)) {
            x += c - address[1];
        } else
            x += address[1] + 1;
        return x;
    }
}

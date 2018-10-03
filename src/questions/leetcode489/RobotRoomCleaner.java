package questions.leetcode489;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private void find(Robot robot, Set<String> visited, int cur_direction, int row, int col) {
        StringBuilder sb = new StringBuilder();
        sb.append(row);
        sb.append('-');
        sb.append(col);
        visited.add(sb.toString());
        robot.clean();

        for (int i=0; i<4; i++) {
            int dir = (i + cur_direction) % 4;
            int r = row + direction[dir][0];
            int c = col + direction[dir][1];
            sb = new StringBuilder();
            sb.append(r);
            sb.append('-');
            sb.append(c);

            if (!visited.contains(sb.toString()) && robot.move()) {
                find(robot, visited, dir, r, c);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnLeft();
        }
    }

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        find(robot, visited, 0, 0, 0);
    }

    private class Robot {
        boolean move() {
            return true;
        }

        void turnLeft() {

        }

        void turnRight() {

        }

        void clean() {

        }
    }
}

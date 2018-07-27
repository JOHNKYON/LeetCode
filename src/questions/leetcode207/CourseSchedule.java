package questions.leetcode207;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] matrix = new int[n][n];

        for (int i = 0; i<prerequisites.length; i++){
            int[] pair = prerequisites[i];
            matrix[pair[0]][pair[1]] = 1;
        }

        for(int i = 0; i < n; i++){
            if (!val(matrix, i, n))
                return false;
        }
        return true;
    }

    private boolean val(int[][] matrix, int i, int n){
        for (int j = 0; j<n; j++){
            if (matrix[i][j] == -1) return false;
            if (matrix[i][j] == 1){

                matrix[i][j] = -1;
                if (val(matrix, j, n))
                    matrix[i][j] = 0;
                else
                    return false;
            }
        }

        return true;
    }
}

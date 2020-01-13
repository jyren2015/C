/**
 * Created by RJYWORK on 2020/1/13
 * Description:
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
            if (obstacleGrid[0][0] == 0) return 1;
        }
        if (obstacleGrid.length == 1) {
            for (int p = 0;p<obstacleGrid[0].length;p++){
                if (obstacleGrid[0][p] == 1) return 0;
            }
        }
        if (obstacleGrid[0].length == 1) {
            for (int[] ints : obstacleGrid) {
                if (ints[0] == 1) return 0;
            }
        }
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = n-1;i>=0;i--){
            if (obstacleGrid[m-1][i] == 1){
                for (int j = i;j>=0;j--){
                    matrix[m-1][i] = Integer.MAX_VALUE;
                }
                break;
            }
            matrix[m-1][i] = 1;
        }
        for (int i = m-1;i>=0;i--){
            if (obstacleGrid[i][n-1] == 1){
                for (int j = i;j>=0;j--){
                    matrix[i][n-1] = Integer.MAX_VALUE;
                }
                break;
            }
            matrix[i][n-1] = 1;
        }
        matrix[m-1][n-1] = 0;
        for (int i = m-2;i>=0;i--){
            for (int j = n-2;j>=0;j--){
                if (obstacleGrid[i][j] == 1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                else if (matrix[i][j+1] == Integer.MAX_VALUE && matrix[i+1][j] == Integer.MAX_VALUE){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                else if (matrix[i][j+1] == Integer.MAX_VALUE){
                    matrix[i][j] = matrix[i+1][j];
                }else if (matrix[i+1][j] == Integer.MAX_VALUE){
                    matrix[i][j] = matrix[i][j+1];
                }
                else {
                    matrix[i][j] = matrix[i][j+1] + matrix[i+1][j];
                }
            }
        }
        if (matrix[0][0] == Integer.MAX_VALUE) return 0;
        return matrix[0][0];
    }
}

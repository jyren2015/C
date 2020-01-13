/**
 * Created by RJYWORK on 2020/1/13
 * Description:
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[m-1][n-1] = grid[m-1][n-1];
        for (int i = n-2;i>=0;i--){
            matrix[m-1][i] = grid[m-1][i] + matrix[m-1][i+1];
        }
        for (int i = m-2;i>=0;i--){
            matrix[i][n-1] = grid[i][n-1] + matrix[i+1][n-1];
        }
        for (int i = m-2;i>=0;i--){
            for (int j = n-2;j>=0;j--){
                matrix[i][j] = grid[i][j] + Math.min(matrix[i][j+1], matrix[i+1][j]);
            }
        }
        return matrix[0][0];
    }
}

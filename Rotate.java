/**
 * Created by RJYWORK on 2019/12/29
 * Description:
 */
public class Rotate {
    public int[][] rotateHelp(int[][] matrix, int i, int j) {
        if (i>j) return matrix;
        int p = j-i+1;
        int[] index = new int[4];
        index[0] = i;
        index[1] = i+p;
        index[2] = i+p;
        index[3] = i;
        for (;p>0;p--){
            int temp = matrix[i][index[0]];
            matrix[i][index[0]] = matrix[index[2]][i];
            matrix[index[2]][i] = matrix[index[1]][index[2]];
            matrix[index[1]][index[2]] = matrix[index[0]][index[1]];
            matrix[index[0]][index[1]] = temp;
            index[0]++;
            index[2]--;
        }
        rotateHelp(matrix, i+1, j-1);
        return matrix;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;
        rotateHelp(matrix, 0, n-2);
    }
}

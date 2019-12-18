/**
 * Created by RJYWORK on 2019/12/17
 * Description:
 */
public class matrixMulti {
    public static int MatrixMulti(int[] index, int m, int n){
        int length = index.length;
        int[][] M = new int[length][length];
        for (int i = 0;i<length;i++){
            for (int j = 0;j<length;j++){
                M[i][j] = Integer.MAX_VALUE;
            }
            M[i][i] = 0;
        }

        for (int k = 1;k<=n-m;k++){
            for (int i = m;i<=n-k;i++){
                for (int j = i;j<i+k;j++){
                    int temp = M[i][j] + M[j+1][i+k] + index[i-1] * index[j] * index[i+k];
                    if (temp<M[i][i+k]){
                        M[i][i+k] = temp;
                    }
                }
            }
        }
        return M[m][n];
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[] index = {2, 4, 5, 3, 6, 5, 7, 3, 9};
        System.out.println(matrixMulti.MatrixMulti(index, m, n));

    }
}

/**
 * Created by RJYWORK on 2020/1/8
 * Description:
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowUp = 0;
        int rowDown = matrix.length - 1;
        int columnLeft = 0;
        int columnRight = matrix[0].length - 1;
        int i = 0;
        int j = 0;
        int flag = 0;
        int number = 1;
        while (i<=rowDown && i>= rowUp && j<=columnRight && j>=columnLeft){
            if (flag == 0 && j<columnRight){
                matrix[i][j] = number;
                number++;
                j = j + 1;
            }
            else if (flag == 0 && j==columnRight){
                matrix[i][j] = number;
                number++;
                i++;
                rowUp++;
                flag = 1;
            }
            else if (flag == 1 && i<rowDown){
                matrix[i][j] = number;
                number++;
                i++;
            }
            else if (flag == 1 && i==rowDown){
                matrix[i][j] = number;
                number++;
                j--;
                columnRight--;
                flag = 2;
            }
            else if (flag == 2 && j>columnLeft){
                matrix[i][j] = number;
                number++;
                j--;
            }
            else if (flag == 2 && j==columnLeft){
                matrix[i][j] = number;
                number++;
                i--;
                rowDown--;
                flag = 3;
            }
            else if (flag == 3 && i>rowUp){
                matrix[i][j] = number;
                number++;
                i--;
            }
            else if (flag == 3 && i==rowUp){
                matrix[i][j] = number;
                number++;
                j++;
                columnLeft++;
                flag = 0;
            }
        }
        return matrix;
    }
}

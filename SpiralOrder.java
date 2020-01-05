import java.util.ArrayList;
import java.util.List;

/**
 * Created by RJYWORK on 2020/1/5
 * Description:
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int rowUp = 0;
        int rowDown = matrix.length - 1;
        int columnLeft = 0;
        int columnRight = matrix[0].length - 1;
        int i = 0;
        int j = 0;
        int flag = 0;
        while (i<=rowDown && i>= rowUp && j<=columnRight && j>=columnLeft){
            if (flag == 0 && j<columnRight){
                list.add(matrix[i][j]);
                j = j + 1;
            }
            else if (flag == 0 && j==columnRight){
                list.add(matrix[i][j]);
                i++;
                rowUp++;
                flag = 1;
            }
            else if (flag == 1 && i<rowDown){
                list.add(matrix[i][j]);
                i++;
            }
            else if (flag == 1 && i==rowDown){
                list.add(matrix[i][j]);
                j--;
                columnRight--;
                flag = 2;
            }
            else if (flag == 2 && j>columnLeft){
                list.add(matrix[i][j]);
                j--;
            }
            else if (flag == 2 && j==columnLeft){
                list.add(matrix[i][j]);
                i--;
                rowDown--;
                flag = 3;
            }
            else if (flag == 3 && i>rowUp){
                list.add(matrix[i][j]);
                i--;
            }
            else if (flag == 3 && i==rowUp){
                list.add(matrix[i][j]);
                j++;
                columnLeft++;
                flag = 0;
            }
        }
        return list;
    }
}

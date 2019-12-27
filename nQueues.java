import java.util.ArrayList;
import java.util.List;

/**
 * Created by RJYWORK on 2019/12/26
 * Description:
 */
public class nQueues {
    public boolean valid(int[] array, int level){
        for (int i = 0;i<level;i++){
            if (array[level] == array[i] || level-i == Math.abs(array[level]-array[i])) return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n){
        List<int[]> list = new ArrayList<>();
        int[] array = new int[n];
        int level = 0;
        while (level>=0){
            boolean flag = valid(array, level);
            if (level == n-1 && array[level] < n && flag){
                list.add(array.clone());
                array[level] = 0;
                level--;
                if (level>=0){
                    array[level]++;
                }
            }
            else if (level == n-1 && array[level] < n && !flag){
                array[level]++;
            }
            else if (level == n-1 && array[level] >= n){
                array[level] = 0;
                level--;
                if (level>=0){
                    array[level]++;
                }
            }
            else if (level < n-1 && array[level] < n && !flag){
                array[level]++;
            }
            else if (level < n-1 && array[level] >= n){
                array[level] = 0;
                level--;
                if (level>=0){
                    array[level]++;
                }
            }
            else {
                level++;
            }
        }



        //下面为格式化输出部分，上面为算法主体
        StringBuilder string = new StringBuilder();
        for (int i = 0;i<n;i++){
            string.append(".");
        }
        List<List<String>> lists = new ArrayList<>();
        for (int[] ints : list) {
            List<String> list1 = new ArrayList<>();
            for (int num : ints) {
                string.replace(num,num+1,"Q");
                list1.add(string.toString());
                string.replace(num,num+1,".");
            }
            lists.add(list1);
        }
        return lists;
    }

    public static void main(String[] args){
        nQueues nQueues = new nQueues();
        System.out.println(nQueues.solveNQueens(5));
    }
}

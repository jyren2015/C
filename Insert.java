import java.util.*;

/**
 * Created by RJYWORK on 2020/1/7
 * Description:
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>(Arrays.asList(intervals));
        boolean flag1 = false;
        for (int k = 0;k<list.size();k++){
            if (list.get(k)[0] >= newInterval[0]){
                flag1 = true;
                list.add(k, newInterval);
                break;
            }
        }
        if (!flag1) list.add(newInterval);
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> list_temp = new ArrayList<>();
        int i = 0;
        while (i<list.size()){
            int[] temp = new int[2];
            temp[0] = list.get(i)[0];
            boolean flag = false;
            while (i+1<list.size() && list.get(i)[1] >= list.get(i+1)[0]){
                flag = true;
                if (list.get(i)[1]>=list.get(i+1)[1]){
                    temp[1] = list.get(i)[1];
                    list.remove(i+1);
                }
                else {
                    i++;
                    temp[1] = list.get(i)[1];
                }
            }
            if (!flag) temp[1] = list.get(i)[1];
            list_temp.add(temp);
            i++;
        }
        int[][] nums = new int[list_temp.size()][2];
        for (int j = 0;j<list_temp.size();j++){
            nums[j][0] = list_temp.get(j)[0];
            nums[j][1] = list_temp.get(j)[1];
        }
        for (int[] num : nums){
            System.out.println(num[0] + "," + num[1]);
        }
        return nums;
    }
}

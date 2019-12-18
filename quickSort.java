import java.util.Arrays;

/**
 * Created by RJYWORK on 2019/12/16
 * Description:
 */
public class quickSort {

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int[] quick_sort(int[] nums, int left, int right){//right为数组下标，小于nums.length
        int i = left;
        int j = right;
        if (left < right){
            int pivot = nums[left];
            while (i < j){
                while (j>i && nums[j] >= pivot) j--;//必须先检查j
                while (i<j && nums[i] <= pivot) i++;
                if (i<j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            nums[left] = nums[i];
            nums[i] = pivot;
            quick_sort(nums, left, i-1);
            quick_sort(nums, i+1, right);
        }
        return nums;
    }

    public static int[] insert(int[] nums){
        for (int p = 0;p<nums.length;p++){
            int ele = nums[p];
            for (int k = p;k>0;k--){
                if (nums[k-1]>ele){
                    nums[k] = nums[k-1];
                    nums[k-1] = ele;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {2,6,1,3,9,34,27,18,28,87,73,90};//3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5
        System.out.println(Arrays.toString(quickSort.quick_sort(nums, 0, 11)));
        int[] nums1 = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};
        System.out.println(Arrays.toString(quickSort.insert(nums1)));
    }

}

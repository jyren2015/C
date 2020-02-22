class SortColors {
    public void sortColors(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0;i<nums.length;i++){
            //System.out.println(Arrays.toString(nums));
            if (nums[i] == 1){
                if (idx1 == -1 && idx2 == -1){
                    idx1 = i;
                }
                else if (idx1 != -1 && idx2 != -1){
                    nums[idx2] = 1;
                    nums[i] = 2;
                    idx2++;
                }
                else if (idx1 == -1){
                    idx1 = idx2;
                    nums[idx1] = 1;
                    nums[i] = 2;
                    idx2++;
                }
            }
            else if (nums[i] == 2){
                if (idx2 == -1){
                    idx2 = i;
                }
            }
            else {
                if (idx1 != -1 & idx2 != -1){
                    nums[i] = 2;
                    nums[idx1] = 0;
                    nums[idx2] = 1;
                    idx1++;
                    idx2++;
                }
                else if (idx1 == -1 && idx2 != -1){
                    nums[idx2] = 0;
                    nums[i] = 2;
                    idx2++;
                }
                else if (idx1 != -1){
                    nums[idx1] = 0;
                    nums[i] = 1;
                    idx1++;
                }
            }
        }
    }
}

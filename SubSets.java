public class SubSets{

    public void subsetsHelper(int serial, int[] nums, int num, Set<Integer> set, Set<List<Integer>> lists){
        if (num == 0){
            List<Integer> list = new ArrayList<>(set);
            lists.add(list);
        }
        for (int i = serial;i<nums.length;i++){
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                subsetsHelper(i, nums, num - 1, set, lists);
                set.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> listSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<=nums.length;i++){
            subsetsHelper(0, nums, i, set, listSet);
        }
        return new ArrayList<>(listSet);
    }
}

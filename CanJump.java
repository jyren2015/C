/**
 * Created by RJYWORK on 2020/1/5
 * Description:
 */
public class CanJump {
    public boolean canJump(int[] nums) {//动态规划
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i = nums.length - 2;i>=0;i--){
            if (nums[i] == 0){
                dp[i] = Integer.MAX_VALUE;
            }
            else {
                dp[i] = Integer.MAX_VALUE;
                int j = 1;
                while (j<=nums[i]){
                    if (dp[j+i] == Integer.MAX_VALUE){
                        j++;
                    }
                    else {
                        dp[i] = 1 + dp[i+j];
                        break;
                    }
                }
            }
        }
        return dp[0] != Integer.MAX_VALUE;
    }
}

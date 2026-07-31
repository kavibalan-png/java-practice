import java.util.Arrays;
public class HouseRobberMemoization {
    public static int rob(int index, int[] nums, int[] dp) {
        // Base Case
        if (index == 0) {
            return nums[0];
        }
        if (index < 0) {
            return 0;
        }
        // Already Calculated
        if (dp[index] != -1) {
            return dp[index];
        }
        // Pick Current House
        int pick = nums[index] + rob(index - 2, nums, dp);
        // Skip Current House
        int notPick = rob(index - 1, nums, dp);
        // Store Answer
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(rob(n - 1, nums, dp));
    }
}
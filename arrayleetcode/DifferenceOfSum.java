p----------ackage arrayleetcode;
class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        for (int n : nums) {
            elementSum += n;
            while (n > 0) {
                digitSum += n % 10;
                n /= 10;
            }
        }
        return Math.abs(elementSum - digitSum);
    }
}
public class DifferenceOfSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 15, 6, 3};
        int result = s.differenceOfSum(nums);
        System.out.println("Difference = " + result);
    }
}
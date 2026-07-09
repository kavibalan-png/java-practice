package arrayleetcode;
class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int p : position) {
            if (p % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(even, odd);
    }
}
public class position {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.minCostToMoveChips(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Minimum Cost = " + result);
    }
}
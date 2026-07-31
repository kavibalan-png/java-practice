import java.util.Arrays;
public class CorporateFlightBookings {
    public static void main(String[] args) {
        int[][] bookings = {
            {1, 2, 10},
            {2, 3, 20},
            {2, 5, 25}
        };
        int n = 5;
        int[] ans = new int[n];
        for (int[] b : bookings) {
            ans[b[0] - 1] += b[2];
            if (b[1] < n)
                ans[b[1]] -= b[2];
        }
        for (int i = 1; i < n; i++)
            ans[i] += ans[i - 1];
        System.out.println(Arrays.toString(ans));
    }
}

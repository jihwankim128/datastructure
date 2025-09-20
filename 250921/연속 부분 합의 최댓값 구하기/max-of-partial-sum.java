// AM 02:26 ~ 02:30 -> 4m

import java.util.Scanner;

public class Main {

    static int n;
    static int[] nums, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        solve();
    }

    static void solve() {
        int maxNum = dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxNum = Math.max(maxNum, dp[i]);
        }
        System.out.println(maxNum);
    }
}
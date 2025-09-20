// AM 01:51 ~ 01:59 -> 8m
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        solve();
    }

    static void solve() {
        for (int num: arr) {
            if (num > m) continue;
            for (int j = m; j >= num; j--) {
                if (!dp[j - num]) continue;
                dp[j] = true;
            }
            dp[num] = true;
        }
        System.out.println(dp[m] ? "Yes" : "No");
    }
}
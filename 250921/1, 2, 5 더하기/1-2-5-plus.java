import java.util.Scanner;
public class Main {
    
    static int n;
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve();
    }

    static void solve() {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i - 2 < 0) continue;
            dp[i] = (dp[i] + dp[i - 2]) % 10007;
            if (i - 5 < 0) continue;
            dp[i] = (dp[i] + dp[i - 5]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
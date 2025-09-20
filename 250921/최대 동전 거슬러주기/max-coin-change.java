import java.util.*;
public class Main {

    static int n, m;
    static int[] coin, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coin = new int[n];
        dp = new int[10001];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        solve();
    }

    static void solve() {
        Arrays.sort(coin);
        for (int c: coin) {
            dp[c] = 1;
            for (int i = c + c; i <= m; i++) {
                if (dp[i - c] == 0) continue;
                dp[i] = Math.max(dp[i], dp[i - c] + 1);
            }
        }
        System.out.println(dp[m] == 0 ? -1 : dp[m]);
    }
}
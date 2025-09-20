import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] coin, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coin = new int[n];
        dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
            
        solve();
    }

    static void solve() {
        for (int i = 1; i <= m; i++) dp[i] = Integer.MAX_VALUE; 
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < coin[j]) continue;
                if (dp[i - coin[j]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }
        System.out.println(dp[m]);
    }
}
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
        for (int c : coin) {
            for (int i = c; i <= m; i++) {  // c부터 시작
                if (i == c || dp[i - c] > 0) {  // 첫 동전이거나 만들 수 있는 경우
                    dp[i] = Math.max(dp[i], dp[i - c] + 1);
                }
            }
        }
        
        System.out.println(dp[m] == 0 ? -1 : dp[m]);
    }
}
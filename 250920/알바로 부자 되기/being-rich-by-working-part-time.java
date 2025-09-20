// PM 08:21 ~ 08:32 -> 11m
import java.util.Scanner;
public class Main {

    static int n;
    static int[] s, e, p, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n];
        e = new int[n];
        p = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        
        solve();
    }

    static void solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = p[i];
            for (int j = 0; j < i; j++) {
                // 이전 날짜에서 이어서 할 수 있는 경우 -> 날짜 증가순
                if (e[j] < s[i]) {
                    // 시작일이 이전 날짜 끝보다 큰 경우,
                    // 그 중 가장 비싼 돈이 누적된 경우
                    dp[i] = Math.max(dp[j] + p[i], dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
// PM 02:07 ~ 02:13 -> 6m
import java.util.Scanner;
public class Main {

    static int[] dp = new int[1001];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve();
    }

    static void solve() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
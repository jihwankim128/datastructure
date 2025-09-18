// pm 02:03 ~ 02:05 -> 2m
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
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        System.out.println(dp[n]);
    }
}
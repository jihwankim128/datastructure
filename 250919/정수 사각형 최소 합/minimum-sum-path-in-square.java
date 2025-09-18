// AM 01:55 ~ 02:08 -> 13m
import java.util.*;
public class Main {

    static int n;
    static int[][] matrix, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n + 2][n + 2];
        dp = new int[n + 2][n + 2];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                matrix[i][j] = sc.nextInt();
        
        dp[1][n] = matrix[1][n];
        for (int i = n - 1; i >= 1; i--) {
            dp[1][i] = dp[1][i + 1] + matrix[1][i];
        }
        for (int i = 2; i <= n; i++) {
            dp[i][n] = dp[i - 1][n] + matrix[i][n];
        }
        solve();
    }

    static void solve() {
        for (int i = 2; i <= n; i++) {
            for (int j = n - 1; j >= 1; j--) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + matrix[i][j];
            }
        }

        System.out.println(dp[n][1]);
    }
}
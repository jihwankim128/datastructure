// AM 01:10 ~ 01:16 -> 6m
import java.util.Scanner;
public class Main {

    static int n;
    static int[][] matrix, dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        solve();
    }

    static void solve() {
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], matrix[0][i]);
            dp[i][0] = Math.max(dp[i - 1][0], matrix[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], matrix[i][j]);
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
// AM 12:48 ~ 01:02 -> 14m
import java.util.*;
public class Main {

    static int n;
    static int[][] matrix, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        dp[1][1] = matrix[1][1];
        solve();
    }

    static void solve() {
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) continue;
                dp[i][j] = Math.min(Math.max(dp[i-1][j], dp[i][j-1]), matrix[i][j]);
            }
        System.out.println(dp[n][n]);
    }
}
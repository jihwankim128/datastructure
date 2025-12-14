import java.util.Scanner;

public class Main {

    static int n;
    static int[][] grid;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        dp = new int[n][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            // 첫번째 행 채우기
            dp[0][i][0] = Math.min(dp[0][prev][0], grid[0][i]);
            dp[0][i][1] = Math.max(dp[0][prev][1], grid[0][i]);
            // 첫번째 열 채우기
            dp[i][0][0] = Math.min(dp[prev][0][0], grid[i][0]);
            dp[i][0][1] = Math.max(dp[prev][0][1], grid[i][0]);
        }

        solve();
    }

    static void solve() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int leftMinV = dp[i][j - 1][0];
                int leftMaxV = dp[i][j - 1][1];
                int upMinV = dp[i - 1][j][0];
                int upMaxV = dp[i - 1][j][1];

                if (upMaxV - upMinV < leftMaxV - leftMinV) {
                    dp[i][j][0] = Math.min(grid[i][j], upMinV);
                    dp[i][j][1] = Math.max(grid[i][j], upMaxV);
                } else {
                    dp[i][j][0] = Math.min(grid[i][j], leftMinV);
                    dp[i][j][1] = Math.max(grid[i][j], leftMaxV);
                }
            }
        }
        int[] result = dp[n - 1][n - 1];
        System.out.println(result[1] - result[0]);
    }
}
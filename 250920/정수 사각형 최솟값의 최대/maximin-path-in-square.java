// AM 12:48 ~ 01:02 -> 14m
import java.util.Scanner;
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
        System.out.println(solve(n, n));
    }

    static int solve(int x, int y) {
        if (x < 1 || y < 1) return 0;
        if (dp[x][y] != 0) return dp[x][y];
        
        // 이전 구간에서 더 큰 값들을 찾음.
        int prev = Math.max(solve(x - 1, y), solve(x, y - 1));
        // 이전 구간보다 현재 값이 작으면 현재값으로 업데이트
        return dp[x][y] = Math.min(prev, matrix[x][y]);
    }
}
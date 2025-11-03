import java.util.*;
public class Main {

    static int[] coin;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }
        
        System.out.println(solve());
    }

    static int solve() {
        int[][] dp = new int[n + 1][4];
        // 가장 처음에 1칸을 밟은 경우
        dp[1][1] = coin[1];
        for (int i = 2; i <= n; i++) {
            // 기본은 2칸씩 = 2칸 전 + 현재 칸
            dp[i][0] = dp[i - 2][0] + coin[i];
            for (int k = 0; k < 3; k++) {
                dp[i][k + 1] = Math.max(dp[i - 2][k], dp[i - 1][k]) + coin[i];
            }
        }

        int maxCoin = 0;
        for (int i = 0; i < 4; i++) {
            maxCoin = Math.max(dp[n][i], maxCoin);
        }
        return maxCoin;
    }
}
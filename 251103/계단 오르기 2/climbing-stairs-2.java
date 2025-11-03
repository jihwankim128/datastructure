import java.util.*;

public class Main {
    static int[] coin;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coin = new int[n + 1];
        for (int i = 1; i <= n; i++) coin[i] = sc.nextInt();
        System.out.println(solve());
    }

    static int solve() {
        final int NEG = -1_000_000_000;
        int[][] dp = new int[n + 1][4]; // cnt = 0..3 (총 1칸 이동 횟수)
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], NEG);

        dp[0][0] = 0; // 0층에서 1칸 이동 0번 사용, 얻은 동전 0

        for (int i = 1; i <= n; i++) {
            for (int cnt = 0; cnt <= 3; cnt++) {
                // 1칸에서 온 경우 (사용한 1칸 수가 하나 늘어남)
                if (cnt >= 1 && dp[i - 1][cnt - 1] != NEG) {
                    dp[i][cnt] = Math.max(dp[i][cnt], dp[i - 1][cnt - 1] + coin[i]);
                }
                // 2칸에서 온 경우 (총 1칸 사용 횟수는 변하지 않음)
                if (i - 2 >= 0 && dp[i - 2][cnt] != NEG) {
                    dp[i][cnt] = Math.max(dp[i][cnt], dp[i - 2][cnt] + coin[i]);
                }
            }
        }

        int ans = NEG;
        for (int cnt = 0; cnt <= 3; cnt++) ans = Math.max(ans, dp[n][cnt]);
        return ans == NEG ? 0 : ans;
    }
}

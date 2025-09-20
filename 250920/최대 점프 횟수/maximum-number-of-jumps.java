// PM 08:06 ~ 08:17 -> 11m
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve();    
    }

    static void solve() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j != 0 && dp[j] == 0) continue;
                if (arr[j] == 0) continue;
                // j 에서 점프 했을 때, 현재 위치에 올 수 있다면
                if (i <= arr[j] + j) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            //System.out.print(dp[i] + " ");
            maxJump = Math.max(maxJump, dp[i]);
        }
        System.out.println(maxJump);
    }
}
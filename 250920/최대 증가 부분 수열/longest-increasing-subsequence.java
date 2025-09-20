// PM 01:25 ~ 01:37 -> 12m
import java.util.Scanner;
public class Main {

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        solve();
    }

    static void solve() {
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxNum = Math.max(dp[i], maxNum);
                }
            }
        }
        System.out.println(maxNum);
    }
}
// PM 07:57 ~ 08:03 -> 6m
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
        int len = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    len = Math.max(dp[i], len);
                }
            }
        }
        System.out.println(len);
    }
}
// PM 01:25 ~ 01:33 -> 8m
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
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i - 1] < arr[i]) dp[i]++; 
        }
        System.out.println(dp[n - 1]);
    }
}
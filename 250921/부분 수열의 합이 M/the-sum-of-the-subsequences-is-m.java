import java.util.Scanner;
public class Main {

    static int n, m;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve();
    }

    static void solve() {
        for (int i = 1; i <= m; i++) {
            dp[i] = (int) 1e9;
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= arr[i]; j--) {
                int prev = j - arr[i];
                dp[j] = Math.min(dp[j], dp[prev] + 1); 
            }
        }

        System.out.println(dp[m] == (int) 1e9 ? -1 : dp[m]);
    }
}
// AM 02:01 ~ 02:11 -> 10m
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        dp = new boolean[sum + 1];

        if (sum % 2 == 1) System.out.println("No");
        else solve(sum / 2);
    }

    static void solve(int m) {
        for (int num: arr) {
            if (num > m) continue;
            for (int j = m; j >= num; j--) {
                if (!dp[j - num]) continue;
                dp[j] = true;
            }
            dp[num] = true;
        }
        
        System.out.println(dp[m] ? "Yes" : "No");
    }
}
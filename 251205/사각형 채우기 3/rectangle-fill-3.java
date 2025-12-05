import java.util.Scanner;
public class Main {
    
    static long[] dp = new long[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[1] = 2;
        dp[2] = 7;
        long sum = 9;

        for (int i = 3; i <= n; i++) {
            dp[i] = (sum * 2 + dp[i - 2] + 2) % 1000000007L;
            sum += dp[i];
        }

        System.out.println(dp[n]);
    }
}
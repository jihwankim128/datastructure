// PM 01:59 ~ 
import java.util.Scanner;
public class Main {

    static int[] dp = new int[46];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println(dp[n]);
    }
}
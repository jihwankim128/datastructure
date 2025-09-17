import java.util.Scanner;

public class Main {

    static int n, m, ans;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        solve(0, 0, 0);
        System.out.println(ans);
    }

    static void solve(int k, int cnt, int sum) {
        if (k >= n) {
            if (cnt == m) ans = Math.max(ans, sum);
            return;
        };

        solve(k + 1, cnt + 1, sum ^ A[k]);
        solve(k + 1, cnt, sum);
    }
}
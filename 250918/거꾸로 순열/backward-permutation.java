import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] ans = new int[9];
    static boolean[] visited = new boolean[9];
    static int n;

    public static void main(String[] args) {
        n = sc.nextInt();
        solve(0);
        System.out.print(sb.toString());
    }

    static void solve(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[k] = i;
            solve(k + 1);
            visited[i] = false;
        }
    }
}
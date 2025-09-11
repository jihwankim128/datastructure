import java.util.Scanner;
public class Main {

    static int n, x, y;
    static int[] roots;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        roots = new int[n + 1];

        for (int i = 1; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            roots[y] = x;
        }
        
        solve();
    }

    static void solve() {
        for (int i = 2; i <= n; i++) {
            System.out.println(roots[i]);
        }
    }
}
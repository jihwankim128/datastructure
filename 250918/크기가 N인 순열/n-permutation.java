import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve(0);
    }

    static void solve(int k) {
        if (k >= n) {
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans.add(i);
            solve(k + 1);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }
}
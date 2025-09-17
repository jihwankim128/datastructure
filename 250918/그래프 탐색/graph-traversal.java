import java.util.*;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static ArrayList<Integer>[] graph = new ArrayList[10005];
    static boolean[] visited = new boolean[10005];

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited[1] = true;
        solve(1);
        System.out.println(ans);
    }

    static void solve(int now) {
        for (int next: graph[now]) {
            if (visited[next]) continue;
            visited[next] = true;
            ans++;
            solve(next);
        }
    }
}
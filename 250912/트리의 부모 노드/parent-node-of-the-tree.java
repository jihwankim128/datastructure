import java.util.*;

public class Main {

    static int n, x, y;
    static ArrayList<Integer>[] trees;
    static int[] roots;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        roots = new int[n + 1];
        trees = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            trees[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            trees[x].add(y);
            trees[y].add(x);
        }
        
        solve(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(roots[i]);
        }
    }

    static void solve(int root) {
        visited[root] = true;
        for (int child: trees[root]) {
            if (visited[child]) {
                continue;
            }
            roots[child] = root;
            solve(child);
        }
    }
}
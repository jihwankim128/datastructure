// PM 01:23 ~ 01:28 -> 5m
import java.util.*;

public class Main {

    static int n, m;
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
                
        solve();
    }

    static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        grid[0][0] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == 0) continue; 
                grid[nx][ny] = 0;
                q.offer(new int[]{nx, ny});
            }
        }
        
        if (grid[n - 1][m - 1] == 0) System.out.println(1);
        else System.out.println(0);
    }
}
// PM 01:33 ~ 
import java.util.*;

public class Main {

    static int n, k;
    static int[][] grid, starts;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1;
            starts[i][1] = sc.nextInt() - 1;
        }
        
        solve();
    }

    static void solve() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            q.offer(new int[]{starts[i][0], starts[i][1]});
            grid[starts[i][0]][starts[i][1]] = -1;
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] != 0) continue;
                grid[nx][ny] = -1;
                q.offer(new int[]{nx, ny});
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
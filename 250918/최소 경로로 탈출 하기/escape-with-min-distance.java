// PM 01:40 ~ 01:44 -> 4m
import java.util.*;

public class Main {

    static int n, m;
    static int[][] a;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
                
        solve();
    }

    static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        a[0][0] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];
            if (x + 1 == n && y + 1 == m) {
                System.out.println(cnt);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (a[nx][ny] == 0) continue;
                a[nx][ny] = 0;
                q.offer(new int[]{nx, ny, cnt + 1});
            }
        }

        System.out.println(-1);
    }
}
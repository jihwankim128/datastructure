// PM 01:48 ~ 01:57 -> 9m

import java.util.*;

public class Main {

    static int n, r1, c1, r2, c2;
    static int[][] visited = new int[101][101];
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        for (int i = 0; i <= n; i++) Arrays.fill(visited[i], -1);
        solve();
    }

    static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        visited[r1][c1] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if (visited[nx][ny] >= 0) continue;
                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        System.out.println(visited[r2][c2]);
    }
}
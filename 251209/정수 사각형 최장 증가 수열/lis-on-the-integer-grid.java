import java.util.*;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return a[2] - b[2];
    });

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                pq.offer(new int[] {i, j, grid[i][j]});
            }
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] dp = new int[n][n];

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (poll[2] >= grid[nx][ny]) continue;

                dp[nx][ny] = Math.max(dp[nx][ny], dp[poll[0]][poll[1]] + 1);
            }
        }

        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxCnt = Math.max(dp[i][j], maxCnt);
            }
        }
        System.out.println(maxCnt + 1);
    }
}
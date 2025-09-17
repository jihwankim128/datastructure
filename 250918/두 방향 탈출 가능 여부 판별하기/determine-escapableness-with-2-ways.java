import java.util.Scanner;
public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] grid = new int[101][101];
    static int[] dx = {0, 1}, dy = {1, 0};

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        grid[0][0] = 0;        
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int x, int y) {
        if (x + 1 == n && y + 1 == m) {
            ans = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (grid[nx][ny] == 0) continue;
            grid[nx][ny] = 0;
            solve(nx, ny);
        }
    }       
}
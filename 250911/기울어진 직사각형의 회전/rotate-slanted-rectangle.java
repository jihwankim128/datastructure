import java.util.Scanner;
public class Main {
    
    static int n, r, c, m1, m2, m3, m4, dir, nr, nc;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        dir = sc.nextInt();

        solve();
    }

    static void solve() {
        if (dir == 0) {
            // 반시계 방향 회전
            rotateCounterClockWise();
        } else {
            // 시계 방향 회전
            rotateClockWise();
        }
        print();
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static void rotateClockWise() {
        int temp = grid[r][c];
        rotateNe(m1, r, c);     nr = r - m1;    nc = c + m1;   
        rotateNw(m2, nr, nc);   nr = nr - m2;   nc = nc - m2;
        rotateSw(m3, nr, nc);   nr = nr + m3;   nc = nc - m3;
        rotateSe(m4, nr, nc);
        grid[r - 1][c - 1] = temp;
    }

    static void rotateCounterClockWise() {
        int temp = grid[r][c];
        rotateNw(m2, r, c);     nr = r - m2;    nc = c - m2;
        rotateNe(m1, nr, nc);   nr = nr - m1;   nc = nc + m1;
        rotateSe(m4, nr, nc);   nr = nr + m4;   nc = nc + m4;
        rotateSw(m3, nr, nc);
        grid[r - 1][c + 1] = temp;
    }

    // 북동쪽
    static void rotateNe(int m, int x, int y) {
        for (int i = 1; i <= m; i++) {
            int nx = x - 1;
            int ny = y + 1;
            grid[x][y] = grid[nx][ny];
            x = nx;
            y = ny;
        }
    }

    // 북서쪽
    static void rotateNw(int m, int x, int y) {
        for (int i = 1; i <= m; i++) {
            int nx = x - 1;
            int ny = y - 1;
            grid[x][y] = grid[nx][ny];
            x = nx;
            y = ny;
        }
    }

    // 남동쪽
    static void rotateSe(int m, int x, int y) {
        for (int i = 1; i <= m; i++) {
            int nx = x + 1;
            int ny = y + 1;
            grid[x][y] = grid[nx][ny];
            x = nx;
            y = ny;
        }
    }

    // 남서쪽
    static void rotateSw(int m, int x, int y) {
        for (int i = 1; i <= m; i++) {
            int nx = x + 1;
            int ny = y - 1;
            grid[x][y] = grid[nx][ny];
            x = nx;
            y = ny;
        }
    }
}
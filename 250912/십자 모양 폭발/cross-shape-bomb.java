import java.util.*;

public class Main {

    static int n, r, c;
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        
        solve();
    }

    static void solve() {
        boom();
        applyGravity();
        print();
    }

    static void applyGravity() {
        // 각 열 별로 아래로 이동
        for (int i = 0; i < n; i++) {
            int[] gravitied = applyGravity(i);
            for (int j = 0; j < n; j++) {
                grid[j][i] = gravitied[j];
            }
        }
    }

    static int[] applyGravity(int idx) {
        int[] temp = new int[n];
        int next = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][idx] == 0) {
                temp[next++] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][idx] != 0) {
                temp[next++] = grid[i][idx];
            }
        }
        return temp;
    }

    static void boom() {
        // 크기에 따라서 4방향이 터짐
        for (int range = 1; range < grid[r][c]; range++) {
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i] * range;
                int ny = c + dy[i] * range;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                grid[nx][ny] = 0;
            }
        }
        // 제자리가 무조건 터짐
        grid[r][c] = 0;
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
}
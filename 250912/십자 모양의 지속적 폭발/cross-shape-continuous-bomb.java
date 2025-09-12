import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid;
    static int[] bombCols, temp;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        temp = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        bombCols = new int[m];
        for (int i = 0; i < m; i++)
            bombCols[i] = sc.nextInt() - 1;
        
        solve();
    }

    static void solve() {
        // 해당 열의 가장 위의 위치를 찾는다.
        for (int col: bombCols) {
            int row = findRow(col);
            if (row == -1) continue;
            bomb(row, col);
            applyGravity();
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

    static void applyGravity() {
        // 각 열 별로 아래로 이동
        for (int i = 0; i < n; i++) {
            applyGravity(i);
            for (int j = 0; j < n; j++) {
                grid[j][i] = temp[j];
            }
        }
    }

    static void applyGravity(int idx) {
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
    }

    static int findRow(int y) {
        for (int x = 0; x < n; x++) {
            if (grid[x][y] != 0) {
                return x;
            }
        }
        return -1;
    }

    static void bomb(int x, int y) {
        for (int range = 1; range < grid[x][y]; range++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * range;
                int ny = y + dy[i] * range;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                grid[nx][ny] = 0;
            }
        }
        grid[x][y] = 0;
    }
}
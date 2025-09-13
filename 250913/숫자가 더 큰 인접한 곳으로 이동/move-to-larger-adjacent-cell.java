import java.util.*;

public class Main {

    static int n, r, c;
    static int[][] grid = new int[101][101];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        solve();
    }

    static void solve() {
        ArrayList<Integer> trace = new ArrayList<>();
        trace.add(grid[r][c]);

        while (canMove()) {
            move();
            trace.add(grid[r][c]);
        }
        print(trace);
    }

    static void print(ArrayList<Integer> trace) {
        StringBuilder sb = new StringBuilder();
        for (int x: trace) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString());
    }

    static boolean canMove() {
        // 4방향 중 큰 숫자가 있을 경우
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (grid[nx][ny] > grid[r][c]) {
                return true;
            }
        }
        return false;
    }

    static void move() {
        // dx, dy에 의해 초기화된 상하좌우 우선순위로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            // 가장 먼저 큰 값이 발견될 경우, 우선순위 탐색을 마친거 -> 이동
            if (grid[nx][ny] > grid[r][c]) {
                r = nx;
                c = ny;
                break;
            }
        }
    }
}
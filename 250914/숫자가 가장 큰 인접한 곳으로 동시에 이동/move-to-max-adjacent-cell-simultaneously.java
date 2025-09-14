// pm 01:02 ~ 01:52 -> 50m
// 문제 이해 잘못 -> 현재 위치보다 큰 X, 그냥 상하좌우 중 가장 큰 곳으로 이동
import java.util.*;

public class Main {

    static int n, m, t;
    static int[][] grid, moved;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        moved = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            moved[x][y] = 1;
        }
        
        solve();
    }

    static void debugging(String message) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(moved[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------> " + message);
    }

    static void solve() {
        //debugging("init");
        // t초 동안 작업을 수행한다.
        while (t-- > 0) {
            // 현재 구슬 위치를 가져온다.
            ArrayList<int[]> marbles = getPos();
            // 이동한다
            move(marbles);
            // 충돌한 구슬을 처리한다.
            //debugging("moved");
            conflictProcess();
            //debugging("confilct");
        }
        // 구슬의 수를 출력
        System.out.println(getPos().size());
    }

    static ArrayList<int[]> getPos() {
        ArrayList<int[]> marbles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (moved[i][j] == 1) {
                    marbles.add(new int[] {i, j});
                }
            }
        }
        return marbles;
    }

    static void move(ArrayList<int[]> marbles) {
        for (int[] marble: marbles) {
            int x = marble[0];
            int y = marble[1];

            // 가장 큰 값을 찾는다.
            int maxNum = 0;
            int mx = x;
            int my = y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (maxNum < grid[nx][ny]) {
                    maxNum = grid[nx][ny];
                    mx = nx;
                    my = ny;
                }
            }
            
            moved[mx][my]++;
            moved[x][y]--;
        }
    }

    static void conflictProcess() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (moved[i][j] > 1) {
                    moved[i][j] %= 2;
                }
            }
        }
    }
}
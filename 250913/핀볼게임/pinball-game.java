// pm 17:20 ~ 17:44 
// -> +13분 ~ 17:57
// 총 37분
import java.util.*;

public class Main {

    static int n;
    static int[][] grid = new int[101][101];
    static int[][] dirs = new int[128][4];
    static int[][] debugCheck = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        dirs['U'] = new int[] {-1, 0};
        dirs['D'] = new int[] {1, 0};
        dirs['L'] = new int[] {0, -1};
        dirs['R'] = new int[] {0, 1};
                 
        solve();
    }

    static void solve() {
        int maxSec = 0;
        // 위 아래 왼쪽 오른쪽 각 방향에서 구슬들을 삽입한다.
        for (int i = 0; i < n; i++) {
            maxSec = Math.max(maxSec, shoot(i, 0, 'R'));
            maxSec = Math.max(maxSec, shoot(i, n - 1, 'L'));
        }
        for (int i = 0; i < n; i++) {
            maxSec = Math.max(maxSec, shoot(n - 1, i, 'U'));
            maxSec = Math.max(maxSec, shoot(0, i, 'D'));
        }
        System.out.println(maxSec);
    }

    static void debugging(int count) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(debugCheck[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println("---------" + count);
    }

    static int shoot(int x, int y, char dir) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        dir = determineNext(dir, x, y);
        int count = 1;
        debugCheck[x][y] = 2;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nx = poll[0] + dirs[dir][0];
            int ny = poll[1] + dirs[dir][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;

            dir = determineNext(dir, nx, ny);
            q.offer(new int[] {nx, ny});
            count++;
            debugCheck[nx][ny] = 1;
        }
        return count + 1;
    }

    static char determineNext(char dir, int x, int y) {
        if (grid[x][y] == 1) {
            if (dir == 'R') return 'U';
            if (dir == 'U') return 'R';
            if (dir == 'D') return 'L';
            if (dir == 'L') return 'D';
        }
        
        if (grid[x][y] == 2) {
            if (dir == 'R') return 'D';
            if (dir == 'U') return 'L';
            if (dir == 'D') return 'R';
            if (dir == 'L') return 'U';
        }
        return dir;
    }
}
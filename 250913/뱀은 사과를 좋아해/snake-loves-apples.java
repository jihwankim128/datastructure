// 16:11 ~ 17:52 
import java.util.*;

public class Main {

    static int n, m, k, p;
    static int[][] board = new int[101][101];
    static int[][] dirs = new int[128][4];
    static Scanner sc = new Scanner(System.in);
    static char d;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        // 사과의 위치
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            board[x][y] = -1;
        }

        dirs['U'] = new int[] {-1, 0};
        dirs['D'] = new int[] {1, 0};
        dirs['R'] = new int[] {0, 1};
        dirs['L'] = new int[] {0, -1};

        solve();
    }

    static void solve() {
        // 뱀이 전부 움직인 경우 게임이 종료된다.
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{0, 0});
        board[0][0] = 1;
        int sec = 0;
        boolean end = false;
        for (int i = 0; i < k; i++) {
            d = sc.next().charAt(0);
            p = sc.nextInt();

            if (end) continue;
            // 게임을 진행할 수 있는지 ?
            for (int j = 0; j < p; j++) {
                sec++;
                if (!move(dq)) {
                    end = true;
                    break;
                }
            }
        }

        System.out.println(sec);
    }

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    static boolean move(Deque<int[]> dq) {
        int[] pos = dq.peekLast();
        int nx = pos[0] + dirs[d][0];
        int ny = pos[1] + dirs[d][1];

        // 벽에 부딪히면 종료
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
        // 사과가 없으면 꼬리가 줄어든다.
        if (board[nx][ny] == 0) {
            int[] tail = dq.pollFirst();
            board[tail[0]][tail[1]] = 0; // 꼬리 제거
        }
    
        if (board[nx][ny] == 1) return false;
        dq.offerLast(new int[]{nx, ny});
        board[nx][ny] = 1;

        return true;
    }
}
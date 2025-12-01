import java.util.*;

public class Main {

    static int n, m, x, y;
    static char d;
    static int[][] dir = new int[128][2];

    public static void main(String[] args) {
        dir['L'] = new int[] {0, -1};
        dir['R'] = new int[] {0, 1};
        dir['U'] = new int[] {-1, 0};
        dir['D'] = new int[] {1, 0};

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            Queue<int[]> q = new LinkedList<>();
            int[][] board = new int[n][n];
            for (int i = 0; i < m; i++) {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                d = sc.next().charAt(0);
                board[x][y] = 1;
                q.offer(new int[] {x, y, (int)d});
            }
            solve(board, q);
            System.out.println(q.size());
        }
    }

    static void solve(int[][] board, Queue<int[]> q) {
        for (int time = 0; time < n * 2; time++) {
            int moveCnt = q.size();
            for (int i = 0; i < moveCnt; i++) {
                int[] marble = q.poll();
                int nx = marble[0] + dir[marble[2]][0];
                int ny = marble[1] + dir[marble[2]][1];
                
                // 벽에 부딪혔다면 뒤집히기
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    int nd = reverseDir(marble[2]);
                    q.offer(new int[]{marble[0], marble[1], nd});
                } 
                // 부딪히지 않았다면 이동하기
                else {
                    board[marble[0]][marble[1]]--;
                    board[nx][ny]++;
                    q.offer(new int[]{nx, ny, marble[2]});
                }
            }
            // 충돌한 구슬 제거하기
            for (int i = 0; i < moveCnt; i++) {
                int[] marble = q.poll();
                if (board[marble[0]][marble[1]] <= 1) {
                    q.offer(marble);
                }
            }
            // 제거된 구슬 board에 업데이트
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > 1) board[i][j] = 0;
                }
            }
        }
    }

    static int reverseDir(int d) {
        if ((char) d == 'L') return 'R';
        if ((char) d == 'R') return 'L';
        if ((char) d == 'U') return 'D';
        return 'U';
    } 
}
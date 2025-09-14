// am 11:50 ~ 12:03 -> 13분 
import java.util.Scanner;

public class Main {

    static int n, m, r, c;
    static boolean[][] bombs = new boolean[101][101];
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        
        solve();
    }

    static void solve() {
        // t-1 의 있던 폭탄의 2^(t-1) 위치까지 폭탄이 생긴다.
        int t = 0;
        bombs[r][c] = true;
        while (++t <= m) {
            // 다음 폭탄 거리 구하기
            int distance = calculateDistance(t);
            // 폭탄 터트리기
            boolean[][] explosion = explode(distance);
            // 업데이트
            bombs = explosion;
        }
        // 폭탄 수 구하기
        print();
    }

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((bombs[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    static boolean[][] explode(int distance) {
        boolean[][] visited = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombs[i][j]) {
                    visited[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d] * distance;
                        int ny = j + dy[d] * distance;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return visited;
    }

    static int calculateDistance(int time) {
        int distance = 1;
        for (int i = 1; i < time; i++) {
            distance *= 2;
        }
        return distance;
    } 

    static void print() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombs[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
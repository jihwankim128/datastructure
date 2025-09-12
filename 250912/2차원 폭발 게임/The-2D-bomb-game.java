// 05:55 시작 ~ 06:29 종료 -> 34분 소요
// 2차 실행 06:3
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] grid = new int[101][101];
    static int[][] rotation = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        solve();
    }

    static void solve() {
        // k번의 작업을 한다. 
        while (k-- > 0) {
            // 터트릴게 없을 때까지 반복해야된다.
            bombLoop();
            // 90도 회전을 한다.
            rotate();
            // 아래로 모두 떨어뜨린다.
            drop();
        }
        // k 번 이후에도 남아있다면 터트린다.
        bombLoop();
        // 남은 폭탄의 수를 출력한다.
        print();
    }

    static void bombLoop() {
        boolean isBomb = true;
        while (isBomb) {
            // 전체 행에서 m개의 연속된 폭탄을 터트린다.
            isBomb = bomb();
            // m개가 터진 후 아래로 모두 떨어진다.
            drop();
        }
    }

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    static void rotate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotation[j][n - i - 1] = grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rotation[i][j];
            }
        }
    }

    static void drop() {
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int next = 0;
            for (int j = n - 1; j >= 0; j--) {
                int value = grid[j][i];
                if (value > 0) {
                    temp[next++] = value;
                }
            }
            for (int j = 0; j < n; j++) {
                grid[n - j - 1][i] = temp[j];
            }
        }
    }

    static boolean bomb() {
        boolean isBomb = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // m 개 이상의 터트릴게 있다면
                int same = countSame(i, j);
                if (same >= m) {
                    isBomb = true;
                    for (int k = j; k < j + same; k++) {
                        grid[k][i] = 0;
                    }
                }
            }
        }
        return isBomb;
    }

    static int countSame(int x, int y) {
        if (grid[y][x] == 0) return 0;

        int count = 1;
        int next = y;
        while (++next < n) {
            if (grid[y][x] == grid[next][x]) count++;
            else break;
        }
        return count;
    }

    static void print() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) count++;
            }
        }
        System.out.println(count);
    }
}
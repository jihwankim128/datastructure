// PM 02:40 ~ 03:17

import java.util.Scanner;

public class Main {

    static int n, m, k;
    static int[][] grid = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        solve();
    }

    static void solve() {
        // 각 행 별로 새로운 블록을 쌓을 수 있는 행을 찾는다.
        int idx = findCanIdx();
        stack(idx);
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

    static void stack(int idx) {
        for (int j = k; j < k + m; j++) {
            grid[idx][j] = 1;
        }
    }

    static int findCanIdx() {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            boolean canStack = true;
            for (int j = k; j < k + m; j++) {
                if (grid[i][j] == 1) {
                    canStack = false;
                }
            }
            if (!canStack) break;
            idx = i;
        }
        return idx;
    }
}
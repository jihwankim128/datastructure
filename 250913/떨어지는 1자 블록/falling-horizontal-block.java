// PM 02:40 ~ 

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
        // 1행짜리 격자판이라면 그냥 처리
        if (n == 1) {
            stack(0);
        } else {
            // 기존 격자판을 모두 탐색
            for (int i = 0; i < n; i++) {
                // 각 행 별로 새로운 블록을 쌓을 수 있는지 확인
                boolean can = canStack(i);
                if (!can) {
                    // 쌓을 수 있다면 쌓는다.
                    stack(i - 1);
                    break;
                }
            }
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

    static void stack(int idx) {
        for (int j = k; j < k + m; j++) {
            grid[idx][j] = 1;
        }
    }

    static boolean canStack(int idx) {
        // idx 행의 k번째부터 blockSize까지 유효한지
        for (int i = k; i < k + m; i++) {
            if (grid[idx][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
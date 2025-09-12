// 19:01 시작 19:21 종료 -> 20분 소요
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] grid = new int[51][51];
    static int[][] copy = new int[51][51];
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                copy[i][j] = grid[i][j];
            }
        
        solve();
    }

    static void solve() {
        int maxPair = 0;
        // 모든 구간에 대해 격자를 터트려본다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bomb(i, j);
                // 터트린 후 모두 아래로 떨어트린다.
                drop();
                // 쌍의 개수를 센다. 
                maxPair = Math.max(maxPair, countPair());
                // 원상복구한다.
                rollback();
            }
        }
        System.out.println(maxPair);
    }

    static void rollback() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = copy[i][j];
            }
        }
    }

    static int countPair() {
        int count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 0) continue;
                int nx = x + 1;
                int ny = y + 1;
                if (nx < n && grid[x][y] == grid[nx][y]) {
                    count++;
                }
                if (ny < n && grid[x][y] == grid[x][ny]) {
                    count++;
                }
            }
        }
        return count;
    }

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
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

    static void drop() {
        for (int i = 0; i < n; i++) {
            int[] temp = new int[51];
            int next = 0;   
            // 한 행씩 저장
            for (int j = n - 1; j >= 0; j--) {
                if (grid[j][i] == 0) continue;
                temp[next++] = grid[j][i];
            }
            // 업데이트
            for (int j = 0; j < n; j++) {
                grid[n - j - 1][i] = temp[j];
            }
        }
    }
}
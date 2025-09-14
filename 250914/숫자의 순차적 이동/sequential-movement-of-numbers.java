// pm 01:54 ~ 02:30 -> 36분 소요
// max 값 업데이트를 안해서 20 분 소요
// 오늘 컨디션 제로

import java.util.*;

public class Main {

    static int n, m;
    static int[][] grid = new int[21][21];
    static int[] dx = {0, -1, 0, 1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    static Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        solve(n * n);
    }

    static void debugging(int num, int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------" + num + ", " + x + ", " + y);
    }

    static void solve(int range) {
        while (m-- > 0) {
            for (int i = 1; i <= range; i++) {
                // 숫자가 있는 위치 찾기
                int[] pos = findPos(i);
                // 인접한 8방향 중 가장 큰 녀석과 위치 바꾸기
                swap(pos[0], pos[1]);
                //debugging(i, pos[0], pos[1]);
            }
            /*
            ArrayList<int[]> poses = findPoses(range);
            for (int[] pos: poses) {
                swap(pos[0], pos[1]);
                debugging();
            }*/
        }
        print();
    }

    static ArrayList<int[]> findPoses(int range) {
        ArrayList<int[]> poses = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            // 숫자가 있는 위치 찾기
            int[] pos = findPos(i);
            poses.add(pos);
        }
        return poses;
    }

    static void print() {  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void swap(int x, int y) {
        int maxNum = 0;
        int mx = x, my = y;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (maxNum < grid[nx][ny]) {
                mx = nx;
                my = ny;
                maxNum = grid[nx][ny];
            }
        }
        int temp = grid[x][y];
        grid[x][y] = grid[mx][my];
        grid[mx][my] = temp;
    }

    static int[] findPos(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
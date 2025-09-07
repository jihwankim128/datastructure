import java.util.Scanner;

public class Main {

    // ㄴ 모양은 회전과 뒤집기 모양이 같음
    static int[][][] blocks = {
        { {0, 0}, {-1, 0}, {0, 1} },    // ㄴ
        { {0, 0}, {-1, 0}, {0, -1} },   // ㄴ 왼쪽 뒤집기
        { {0, 0}, {1, 0}, {0, 1} },     // ㄴ 아래 뒤집기
        { {0, 0}, {1, 0}, {0, -1} },    // ㄴ 아래 뒤집고 왼쪽 뒤집기
        { {0, 0}, {0, 1}, {0, 2} },     // - 
        { {0, 0}, {1, 0}, {2, 0} }      // - 90도 회전
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxCount = Math.max(maxCount, countMaxValueOfBlocks(i, j, grid));
            }
        }
        System.out.println(maxCount);
    }

    static int countMaxValueOfBlocks(int x, int y, int[][] grid) {
        int maxCount = 0;
        for (int i = 0; i < blocks.length; i++) {
            maxCount = Math.max(maxCount, countByBlock(i, x, y, grid));
        }
        return maxCount;
    }

    static int countByBlock(int idx, int x, int y, int[][] grid) {
        int count = 0;
        for (int i = 0; i < blocks[idx].length; i++) {
            int nx = x + blocks[idx][i][0];
            int ny = y + blocks[idx][i][1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                return 0;
            }
            count += grid[nx][ny];
        }
        return count;
    }
}
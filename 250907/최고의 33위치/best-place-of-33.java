import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int width = n - 3;
        int maxCount = 0;
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= width; j++) {
                maxCount = Math.max(maxCount, countCoin(i, j, grid));
            }
        }

        System.out.println(maxCount);
    }

    static int countCoin(int x, int y, int[][] grid) {
        int count = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
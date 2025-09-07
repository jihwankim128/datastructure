import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (countRow(i, n, grid) >= m) count++;
            if (countCol(i, n, grid) >= m) count++;
        }

        System.out.println(count);
    }

    static int countRow(int idx, int n, int[][] grid) {
        int prev = 0;
        int count = 1;
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            if (prev == grid[idx][i]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
            prev = grid[idx][i];
        }
        return maxCount;
    } 

    static int countCol(int idx, int n, int[][] grid) {
        int prev = 0;
        int count = 1;
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            if (prev == grid[i][idx]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
            prev = grid[i][idx];
        }
        return maxCount;
    } 
}
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
            int limit = i + 3;
            int count = 0;
            for (int j = i; j < limit; j++) {
                for (int k = i; k < limit; k++) {
                    if (grid[j][k] == 1) {
                        count++;
                    }
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        System.out.println(maxCount);
    }
}
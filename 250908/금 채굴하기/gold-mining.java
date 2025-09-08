import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] grid = new int[21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, mineMaxGold(i, j));
            }
        }
        System.out.println(maxGold);
    }

    static int mineMaxGold(int x, int y) {
        int maxGold = 0;
        for (int k = 0; k <= 2 * n; k++) {
            int goldCount = 0;
            
            // 맨해튼 거리라는 공식이 존재했었음
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.abs(i - x) + Math.abs(j - y) <= k) {
                        goldCount += grid[i][j];
                    }
                }
            }
            
            int cost = k * k + (k + 1) * (k + 1);
            int profit = goldCount * m - cost;
            
            if (profit >= 0) {
                maxGold = Math.max(maxGold, goldCount);
            }
        }
        return maxGold;
    }
}
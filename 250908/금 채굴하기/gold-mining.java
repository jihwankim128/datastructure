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
        int canMiningMaxAmount = 0;
        for (int k = 0; k < n; k++) {
            int miningAmount = mineGold(x, y, k);
            if (k * k + ((k + 1) * (k + 1)) <= miningAmount * m) {
                canMiningMaxAmount = Math.max(canMiningMaxAmount, miningAmount);
            } 
        }
        return canMiningMaxAmount;
    }

    static int mineGold(int x, int y, int k) {
        if (k == 0) return grid[x][y];

        int up = x - k, down = x + k;
        int left = y - k, right = y + k;

        // 마름모 모양 맨위 맨 아래
        int miningAmount = 0;
        if (up >= 0) miningAmount += grid[up][y];
        if (down < n) miningAmount += grid[down][y];
        if (left >= 0) miningAmount += grid[x][left];
        if (right < n) miningAmount += grid[x][right];

        // 그 외는 테두리 형태로
        return miningAmount + mineCenter(x, y, k - 1);
    }

    static int mineCenter(int x, int y, int base) {
        int sx = Math.max(0, x - base);
        int ex = Math.min(n - 1, x + base);
        int sy = Math.max(0, y - base);
        int ey = Math.min(n - 1, y + base);

        int miningAmount = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                miningAmount += grid[i][j];
            }
        }
        return miningAmount;
    }
}
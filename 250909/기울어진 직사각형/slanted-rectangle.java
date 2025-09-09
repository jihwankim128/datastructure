import java.util.Scanner;
public class Main {

    static int[][] grid = new int[21][21];
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        System.out.println(solve());
    }

    static int solve() {
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum = Math.max(maxSum, findMaxFromCenter(i, j));
            }
        }
        return maxSum;
    }

    static int findMaxFromCenter(int centerX, int centerY) {
        int maxSum = 0;
        
        // 모든 가능한 크기의 기울어진 직사각형 시도
        for (int k1 = 1; k1 < n; k1++) {        // 세로 방향 반지름
            for (int k2 = 1; k2 < n; k2++) {    // 가로 방향 반지름
                int perimeterSum = calculatePerimeter(centerX, centerY, k1, k2);
                maxSum = Math.max(maxSum, perimeterSum);
            }
        }
        return maxSum;
    }

    static boolean canDraw(int x, int y, int height, int width) {
        // 왼쪽 대각선 아래로 내려갔을 때 벗어나면 못함
        int ex = x + height, ey = y - height;
        if (ex >= n || ey < 0) return false;
        // 왼쪽 끝점에서 오른쪽 대각선 아래로 내려갔을 때 벗어나면 못함
        if (ex + width >= n || ey + width >= n) return false;
        return true;
    }

    static int calculatePerimeter(int centerX, int centerY, int k1, int k2) {
        int sum = 0;

        // 상단 대각선 (↗ 방향)
        sum += addDiagonalLine(centerX - k1, centerY, k2, 1, 1);
        // 우측 대각선 (↘ 방향)  
        sum += addDiagonalLine(centerX, centerY + k2, k1, 1, -1);
        // 하단 대각선 (↙ 방향)
        sum += addDiagonalLine(centerX + k1, centerY, k2, -1, -1);
        // 좌측 대각선 (↖ 방향)
        sum += addDiagonalLine(centerX, centerY - k2, k1, -1, 1);
        
        return sum;
    }

    static int addDiagonalLine(int startX, int startY, int length, int dirX, int dirY) {
        int sum = 0;
        
        for (int i = 0; i < length; i++) {
            int x = startX + i * dirX;
            int y = startY + i * dirY;
            if (!isInBounds(x, y)) {
                return 0;
            }
            sum += grid[x][y];
        }
        return sum;
    }
    
    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
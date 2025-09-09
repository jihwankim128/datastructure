import java.util.Scanner;

public class Main {
    static int[][] grid = new int[21][21];
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        readGrid(sc);
        System.out.println(findMaxTiltedRectPerimeter());
    }
    
    static void readGrid(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
    
    static int findMaxTiltedRectPerimeter() {
        int maxSum = 0;
        
        // 모든 가능한 중심점에서 시도
        for (int centerX = 0; centerX < n; centerX++) {
            for (int centerY = 0; centerY < n; centerY++) {
                maxSum = Math.max(maxSum, findMaxFromCenter(centerX, centerY));
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
                if (perimeterSum > 0) {  // 유효한 테두리가 있는 경우만
                    maxSum = Math.max(maxSum, perimeterSum);
                }
            }
        }
        return maxSum;
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
            
            if (isInBounds(x, y)) {
                sum += grid[x][y];
            } else {
                return 0;  // 경계를 벗어나면 유효하지 않음
            }
        }
        return sum;
    }
    
    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
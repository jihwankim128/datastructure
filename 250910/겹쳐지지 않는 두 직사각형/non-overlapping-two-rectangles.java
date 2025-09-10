import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] grid = new int[6][6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.print(solve());
    }

    static int solve() {
        int maxSum = -100000;
        // todo: 직사각형을 판단하고 최댓값을 업데이트
        for (int sx = 0; sx < n; sx++) {
            for (int ex = sx; ex < n; ex++) {
                for (int sy = 0; sy < m; sy++) {
                    for (int ey = sy; ey < m; ey++) {
                        int sum1 = findSquareSum(sx, ex, sy, ey);
                        int sum2 = findSecondSquareMaxSum(sx, ex, sy, ey);
                        maxSum = Math.max(maxSum, sum1 + sum2);
                    }
                }
            }
        }

        return maxSum;
    }

    static int findSecondSquareMaxSum(int psx, int pex, int psy, int pey) {
        int maxSum = -100000;
        for (int sx = 0; sx < n; sx++) {
            for (int ex = sx; ex < n; ex++) {
                for (int sy = 0; sy < m; sy++) {
                    for (int ey = sy; ey < m; ey++) {
                        // 그릴 수 있는지 ?
                        if (canDraw(psx, pex, psy, pey, sx, ex, sy, ey)) {
                            maxSum = Math.max(maxSum, findSquareSum(sx, ex, sy, ey));
                        }
                    }
                }
            }
        }
        return maxSum;
    } 

    static boolean canDraw(
        int sx1, int ex1, int sy1, int ey1,
        int sx2, int ex2, int sy2, int ey2
    ) {
        // s2가 s1보다 왼쪽에 있으면 된다.
        if (sy2 > ey1) return true;
        // 같은 열에 있다면 두 번째가 첫 번째보다 아래에 있어야 함
        if (sy2 <= ey1 && sx2 > ex1) return true;
        return false;
    }

    static int findSquareSum(int sx, int ex, int sy, int ey) {
        int sum = 0;
        // todo: height by width 의 직사각형 합 구하기
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
}
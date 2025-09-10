import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid = new int[21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        System.out.println(solve());
    }

    static int solve() {
        int area = -1;
        // 사각형을 만들기
        for (int x1 = 0; x1 < n; x1++) {
            for (int x2 = x1; x2 < n; x2++) {
                for (int y1 = 0; y1 < m; y1++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        // 모두 양수로 구성됐는지 확인
                        if (isAllPositive(x1, x2, y1, y2)) {
                            // 면적 업데이트
                            int h = x2 - x1 + 1;
                            int w = y2 - y1 + 1;
                            area = Math.max(area, h * w);
                        }
                    }
                }
            }
        }
        return area;
    }

    static boolean isAllPositive(int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (grid[i][j] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
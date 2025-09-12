import java.util.Scanner;

public class Main {

    static int[][] grid = new int[4][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);
        solve(dir);
    }

    static void solve(char dir) {
        if (dir == 'R') {
            moveRight();
        } else if (dir == 'L') {
            moveLeft();
        } else if (dir == 'D') {
            moveDown();
        } else {
            moveUp();
        }
        print();
    }

    static void moveUp() {
        // 모든 숫자가 위쪽으로 이동한다.
        for (int i = 0; i < 4; i++) {
            // 아래쪽의 숫자 중 더할 수 있는 경우 더한다.
            for (int j = 0; j <= 3; j++) {
                // 현재 위치에서 맨 아래쪽에 있는 값을 찾는다.
                int down = j;
                while (++down < 4) {
                    if (grid[i][down] != 0) break;
                }
                //현재 숫자와 같은 경우 더한다.
                if (down < 4 && grid[j][i] == grid[down][i]) {
                    grid[j][i] += grid[j][i];
                    grid[down][i] = 0;
                }
                // 위쪽으로 이동한다. 
                for (int up = j - 1; up >= 0; up--) {
                    if (grid[up][i] > 0) break;
                    grid[up][i] = grid[up + 1][i];
                    grid[up + 1][i] = 0;
                }
            }
        }
    }

    static void moveDown() {
        // 모든 숫자가 아래쪽으로 이동한다.
        for (int i = 0; i < 4; i++) {
            // 위쪽의 숫자 중 더할 수 있는 경우 더한다.
            for (int j = 3; j >= 0; j--) {
                // 현재 위치에서 맨 위에 있는 값을 찾는다.
                int up = j;
                while (--up >= 0) {
                    if (grid[up][i] != 0) break;
                }
                //현재 숫자와 같은 경우 더한다.
                if (up >= 0 && grid[j][i] == grid[up][i]) {
                    grid[j][i] += grid[j][i];
                    grid[up][i] = 0;
                }
                // 아래쪽으로 이동한다. 
                for (int down = j + 1; down < 4; down++) {
                    if (grid[down][i] > 0) break;
                    grid[down][i] = grid[down - 1][i];
                    grid[down - 1][i] = 0;
                }
            }
        }
    }

    static void moveLeft() {
        // 모든 숫자가 왼쪽으로 이동한다.
        for (int i = 0; i < 4; i++) {
            // 오른쪽의 숫자 중 더할 수 있는 경우 더한다.
            for (int j = 0; j <= 3; j++) {
                // 현재 위치에서 맨 왼쪽에 있는 값을 찾는다.
                int right = j;
                while (++right < 4) {
                    if (grid[i][right] != 0) break;
                }
                //현재 숫자와 같은 경우 더한다.
                if (right < 4 && grid[i][j] == grid[i][right]) {
                    grid[i][j] += grid[i][j];
                    grid[i][right] = 0;
                }
                // 왼쪽으로 이동한다. 
                for (int left = j - 1; left >= 0; left--) {
                    if (grid[i][left] > 0) break;
                    grid[i][left] = grid[i][left + 1];
                    grid[i][left + 1] = 0;
                }
            }
        }
    }

    static void moveRight() {
        // 모든 숫자가 오른쪽으로 이동한다.
        for (int i = 0; i < 4; i++) {
            // 왼쪽의 숫자 중 더할 수 있는 경우 더한다.
            for (int j = 3; j >= 0; j--) {
                // 현재 위치에서 맨 왼쪽에 있는 값을 찾는다.
                int left = j;
                while (--left >= 0) {
                    if (grid[i][left] != 0) break;
                }
                //현재 숫자와 같은 경우 더한다.
                if (left >= 0 && grid[i][j] == grid[i][left]) {
                    grid[i][j] += grid[i][j];
                    grid[i][left] = 0;
                }
                // 오른쪽으로 이동한다. 
                for (int right = j + 1; right < 4; right++) {
                    if (grid[i][right] > 0) break;
                    grid[i][right] = grid[i][right - 1];
                    grid[i][right - 1] = 0;
                }
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
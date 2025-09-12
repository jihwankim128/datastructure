import java.util.Scanner;

public class Main {

    static int[][] grid = new int[4][4];
    static int[] dir = new int[128]; // ascii로 방향 표현

    static {
        dir['L'] = 0;  // 왼쪽 (기본, 회전 없음)
        dir['U'] = 1;  // 위쪽 (시계방향 90도)
        dir['R'] = 2;  // 오른쪽 (시계방향 180도)
        dir['D'] = 3;  // 아래쪽 (시계방향 270도)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char direction = sc.next().charAt(0);
        solve(direction);
    }

    static void solve(char direction) {
        int rotations = dir[direction];
        
        // 회전시켜서 왼쪽으로 떨어뜨리기
        for (int i = 0; i < rotations; i++) {
            rotateClockwise();
        }
        
        drop();
        
        // 원래 방향으로 되돌리기
        for (int i = 0; i < (4 - rotations) % 4; i++) {
            rotateClockwise();
        }
        
        print();
    }

    static void drop() {
        // 모든 숫자가 왼쪽으로 이동한다.
        for (int i = 0; i < 4; i++) {
            // 오른쪽의 숫자 중 더할 수 있는 경우 더한다.
            for (int j = 0; j <= 3; j++) {
                // 현재 위치에서 맨 오른쪽에 있는 값을 찾는다.
                int right = j;
                while (++right < 4) {
                    if (grid[i][right] != 0) break;
                }
                //현재 숫자와 같은 경우 더한다.
                if (right < 4 && grid[i][j] != 0 && grid[i][j] == grid[i][right]) {
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

    static void rotateClockwise() {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[j][3 - i] = grid[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = temp[i][j];
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
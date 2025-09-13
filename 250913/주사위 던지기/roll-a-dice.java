// pm 03:20 ~ 03:55
import java.util.Scanner;

public class Main {

    // idx -> top: 0, front: 1, right: 2, left: 3, back: 4, bottom: 5
    static int[] dice = { 1, 2, 3, 4, 5, 6 };
    static int n, m, r, c;
    static String[] directions;
    static int[][] dir = new int[128][2];
    static int[][] grid = new int[105][105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        directions = new String[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next();
        }

        dir['R'] = new int[]{0, 1};
        dir['L'] = new int[]{0, -1};
        dir['U'] = new int[]{-1, 0};
        dir['D'] = new int[]{1, 0};

        solve();
    }

    static void solve() {
        grid[r][c] = dice[5];
        // 현재 위치 -> r, c 에서 굴리기 -> String 값에 의해
        for (String direction: directions) {
            char ch = direction.charAt(0);
            int nx = r + dir[ch][0];
            int ny = c + dir[ch][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            role(ch);
            grid[nx][ny] = dice[5];
            r = nx;
            c = ny;
        }
        print();
    }

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    static void print() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += grid[i][j];
            }
        }
        System.out.println(count);
    }

    static void role(char ch) {
        if (ch == 'R') roleRight();
        else if(ch == 'L') roleLeft();
        else if (ch == 'U') roleFront();
        else roleBack();
    }

    // left랑 right는 front, back만 안움직임
    static void roleLeft() {
        int top = dice[0];
        // right -> top
        dice[0] = dice[2];
        // bottom -> right
        dice[2] = dice[5];
        // left -> bottom
        dice[5] = dice[3];
        // top -> left 
        dice[3] = top;
    }

    static void roleRight() {
        int top = dice[0];
        // left -> top
        dice[0] = dice[3];
        // bottom -> left
        dice[3] = dice[5];
        // right -> bottom
        dice[5] = dice[2];
        // top -> right
        dice[2] = top;
    }

    // Front랑 Back은 left랑 right가 안움직임
    static void roleFront() {
        int top = dice[0];
        // front -> top 
        dice[0] = dice[1];
        // bottom -> front
        dice[1] = dice[5];
        // back -> bottom
        dice[5] = dice[4];
        // top -> back
        dice[4] = top;
    }

    // idx -> top: 0, front: 1, right: 2, left: 3, back: 4, bottom: 5
    static void roleBack() {
        int front = dice[1];
        // top -> front
        dice[1] = dice[0];
        // back -> top
        dice[0] = dice[4];
        // bottom -> back
        dice[4] = dice[5];
        // front -> bottom 
        dice[5] = front;
    }
}
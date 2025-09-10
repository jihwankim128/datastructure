import java.util.Scanner;

public class Main {

    static int n, m, q;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            solve(r - 1, d);
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(a[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    static void solve(int r, char d) {
        // 첫 시작은 어떻게 할 것인지?
        // 지속적인 전파는 어떻게 할 것인지?
        char nextDir = move(r, d);
        moveUp(r, nextDir);
        moveDown(r, nextDir);
    }

    static char move(int r, char d) {
        // d를 기준으로 r을 전파하기
        if (d == 'L') {
            moveRight(r);
            return 'R';
        }
        moveLeft(r);
        return 'L';
    }

    static void moveLeft(int x) {
        // 바람의 영향을 받아 왼쪽으로 이동하는 녀석
        // 첫번째 요소가 마지막이 됨
        int first = a[x][0];
        for (int i = 0; i < m - 1; i++) {
            a[x][i] = a[x][i + 1];
        }
        a[x][m - 1] = first;
    }

    static void moveRight(int x) {
        // 오른쪽으로 이동, 마지막 요소가 첫번째가 됨
        int last = a[x][m - 1];
        for (int i = m - 1; i > 0; i--) {
            a[x][i] = a[x][i - 1];
        }
        a[x][0] = last;
    }

    static void moveDown(int x, char nextDir) {
        // 아래로 전파 가능한지 확인하고 맨 아래까지 전파
        for (int i = x + 1; i < n; i++) {
            if (!canSpread(i - 1, i)) break;
            nextDir = move(i, nextDir);
        }
    }

    static void moveUp(int x, char nextDir) {
        // 위로 전파 가능한지 확인하고 맨 위에까지 전파
        for (int i = x - 1; i >= 0; i--) {
            if (!canSpread(i + 1, i)) break;
            nextDir = move(i, nextDir);
        }
    }

    static boolean canSpread(int x1, int x2) {
        // 전파 가능 여부 확인
        // 비교 행의 범위 체크
        if (x2 < 0 || x2 >= n) return false;
        for (int i = 0; i < m; i++) {
            if (a[x1][i] == a[x2][i]) {
                return true;
            }
        }
        return false;
    }
}
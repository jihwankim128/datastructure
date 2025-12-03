import java.util.*;
public class Main {

    static List<Integer>[][] grid;
    static int[] numberPos;
    static int[] moves;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new List[n][n];
        numberPos = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j; 
                grid[i][j] = new ArrayList<>();
                int number = sc.nextInt();
                grid[i][j].add(number);
                numberPos[number] = idx;
            }
        }

        moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        solve();
    }

    static void solve() {
        for (int number: moves) {
            int nextPos = findMaxNumberPos(number);
            // 인접한 여덟 방향에 아무 숫자도 없다면 무시
            if (nextPos == -1) {
                continue;
            }

            // 있다면 해당 숫자 위로 모두 이동
            move(number, nextPos);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].isEmpty()) {
                    System.out.println("None");
                    continue;
                }
                List<Integer> numbers = grid[i][j];
                for (int idx = numbers.size() - 1; idx >= 0; idx--) {
                    System.out.print(numbers.get(idx) + " ");
                }
                System.out.println();
            }
        }
    }

    static void move(int number, int next) {
        int x = numberPos[number] / n;
        int y = numberPos[number] % n;
        int nx = next / n;
        int ny = next % n;

        List<Integer> numbers = new ArrayList<>(grid[x][y]);
        int idx = numbers.indexOf(number);
        for (int i = idx; i < numbers.size(); i++) {
            int moveNumber = numbers.get(i);
            grid[nx][ny].add(moveNumber);
            grid[x][y].remove(idx);
            numberPos[moveNumber] = next;
        }
    }

    static int findMaxNumberPos(int number) {
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        int x = numberPos[number] / n;
        int y = numberPos[number] % n;

        int nextPos = -1;
        int maxNum = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            
            for (int nextNumber: grid[nx][ny]) {
                if (maxNum < nextNumber) {
                    nextPos = nx * n + ny;
                    maxNum = nextNumber;
                }
            };
        }

        return nextPos;
    }
}
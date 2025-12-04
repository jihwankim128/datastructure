import java.util.*;
public class Main {

    static int[][][] ranges = {
        {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}, {2, 0}},
        {{-1, 0}, {0, -1}, {0, 0}, {1, 0}, {0, 1}},
        {{-1, -1}, {1, -1}, {0, 0}, {1, 1}, {-1, 1}}
    };

    static Stack<int[]> st = new Stack<>();
    static int n, ans;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) st.push(new int[] {i, j});
            }
        }
        
        solve();
        System.out.println(ans);
    }

    static void solve() {
        if (st.isEmpty()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == -1) {
                        count++;
                    }
                }
            }
            ans = Math.max(ans, count);
            return;
        }

        for (int[][] range: ranges) {
            int[] pos = st.pop();
            int[][] temp = copy();
            boom(pos, range);

            solve();

            grid = temp;
            st.push(pos);
        }
    }

    static void boom(int[] pos, int[][] range) {
        for (int i = 0; i < 5; i++) {
            int nx = pos[0] + range[i][0];
            int ny = pos[1] + range[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            grid[nx][ny] = -1;
        }
    }

    static int[][] copy() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }
}
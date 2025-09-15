// pm 01:50 ~ 02:16 -> 26m

import java.util.Scanner;

public class Main {

    static int n;
    static int[][] segments;
    static int[] visited = new int[100];
    static int maxCnt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        solve(0);
        System.out.println(maxCnt);
    }

    static void solve(int k) {
        if (k == n) {
            int cnt = selectLine();
            maxCnt = Math.max(cnt, maxCnt);
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;
            visited[i] = i + 1;
            solve(k + 1);
            visited[i] = 0;
        }
    }

    static int selectLine() {
        boolean[] coordinate = new boolean[1001];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int idx = visited[i] - 1;
            int x = segments[idx][0];
            int y = segments[idx][1];

            boolean canSelect = true;
            for (int pos = x; pos <= y; pos++) {
                if (coordinate[pos]) {
                    canSelect = false;
                    break;
                }
                coordinate[pos] = true;
            }

            if (canSelect) cnt++;
        }
        return cnt;
    }
}
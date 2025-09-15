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
            // visited는 기저조건에서
            // 1, 2, 3 -> 1, 3, 2 -> 2, 1, 3 -> 2, 3, 1 -> 3, 1, 2 -> 3, 2, 1
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
        // 1, 2, 3 -> 3, 2, 1 까지의 순열대로 selectLine에 진입하게 됨.
        for (int i = 0; i < n; i++) {
            // 1 based idx -> 0 based idx
            int idx = visited[i] - 1;
            int p1 = segments[idx][0];
            int p2 = segments[idx][1];
            
            if (canSelect(p1, p2, coordinate)) {
                select(p1, p2, coordinate);
                cnt++;
            }
        }
        return cnt;
    }

    static boolean canSelect(int p1, int p2, boolean[] coordinate) {
        for (int pos = p1; pos <= p2; pos++) {
            if (coordinate[pos]) {
                return false;
            }
        }
        return true;
    }

    static void select(int p1, int p2, boolean[] coordinate) {
        for (int pos = p1; pos <= p2; pos++) {
            coordinate[pos] = true;
        }
    }
}

/*
1 2 3 4 5
    1 1 1
1 1 

*/
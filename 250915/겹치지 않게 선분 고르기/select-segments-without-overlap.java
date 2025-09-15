import java.util.Scanner;

public class Main {

    static int n;
    static int[][] segments;
    static boolean[] coordinate = new boolean[1001];
    static int maxCnt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        solve(0, 0);
        System.out.println(maxCnt);
    }

    static void solve(int idx, int currentCnt) {
        // 가지치기: 남은 선분을 모두 선택해도 현재 최댓값을 넘을 수 없다면 종료
        if (currentCnt + (n - idx) <= maxCnt) return;
        
        if (idx == n) {
            maxCnt = Math.max(currentCnt, maxCnt);
            return;
        }

        int p1 = segments[idx][0];
        int p2 = segments[idx][1];
        
        // 현재 선분을 선택하는 경우
        if (canSelect(p1, p2)) {
            select(p1, p2);
            solve(idx + 1, currentCnt + 1);
            unselect(p1, p2);
        }
        
        // 현재 선분을 선택하지 않는 경우
        solve(idx + 1, currentCnt);
    }

    static boolean canSelect(int p1, int p2) {
        for (int pos = p1; pos <= p2; pos++) {
            if (coordinate[pos]) {
                return false;
            }
        }
        return true;
    }

    static void select(int p1, int p2) {
        for (int pos = p1; pos <= p2; pos++) {
            coordinate[pos] = true;
        }
    }
    
    static void unselect(int p1, int p2) {
        for (int pos = p1; pos <= p2; pos++) {
            coordinate[pos] = false;
        }
    }
}
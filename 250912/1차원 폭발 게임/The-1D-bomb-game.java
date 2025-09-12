import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] bombs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        
        solve();
    }

    static void solve() {
        // m 개 이상의 폭탄이 없을 때까지 반복
        while (true) {
            boolean isBomb = false;
            for (int i = 0; i < n; i++) {
                if (canBomb(i)) {
                    bomb(i);
                    isBomb = true;
                }
            }
            if (!isBomb) break;
            update();
        }
        print();
    }

    static boolean canBomb(int idx) {
        if (bombs[idx] == 0 || idx + m >= n) {
            return false;
        }
        for (int next = 1; next < m; next++) {
            if (bombs[idx] != bombs[idx + next]) {
                return false;
            }
        }
        return true;
    }

    static void bomb(int idx) {
        int target = bombs[idx];
        for (int i = idx; i < n; i++) {
            if (target != bombs[i]) break;
            bombs[i] = 0;
        }
    }

    static void update() {
        int[] temp = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (bombs[i] != 0) {
                temp[idx++] = bombs[i];
            }
        }
        bombs = temp;
    }

    static void print() {
        int count = 0;
        for (int x : bombs) {
            if (x != 0) count++;
        }
        if (count == 0) {
            System.out.println(0);
            return;
        };

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int x: bombs) {
            if (x != 0) sb.append(x).append('\n');
        }
        System.out.println(sb.toString());
    }
}
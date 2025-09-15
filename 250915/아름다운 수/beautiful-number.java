// PM 01:18 ~ 01:38 -> 20m
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] numbers = new int[10];
    static int n, cnt;

    public static void main(String[] args) {
        n = sc.nextInt();
        solve(0);
        System.out.println(cnt);
    }

    static void debugging() {
        System.out.println(Arrays.toString(numbers));
        System.out.println("------------");
    }

    static void solve(int k) {
        // 기저조건 : n자리가 되었을 때 처리
        if (k == n) {
            // 아름다운 수인지 판단
            if (isBeautiful()) {
                //debugging();
                cnt++;
            }
            return;
        }

        // 메인 로직
        for (int i = 1; i <= 4; i++) {
            numbers[k] = i; // 1111 -> 1112 -> 4444
            solve(k + 1);
        }
    }

    static boolean isBeautiful() {
        int prev = numbers[0];
        int count = 1;
    
        for (int i = 1; i < n; i++) {
            int now = numbers[i];
            if (prev == now) count++;
            // 연속되지 않는 수가 감지됐을 때,
            else {
                if (count % prev != 0) return false;
                prev = now;
                count = 1;
            }
        }

        if (count % prev != 0) return false;
        return true;
    }
}
// PM 01:00 ~ 01:09 -> 9m

import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] numbers = new int[8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        solve(0);
    }

    static void solve(int count) {
        if (count == n) {
            // 출력
            print();
            return;
        }

        for (int i = 1; i <= k; i++) {
            numbers[count] = i;
            solve(count + 1);
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
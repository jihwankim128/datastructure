import java.util.*;

public class Main {

    static int n, k;
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        solve(0, 0, 0);
    }

    static void solve(int call, int prev, int count) {
        if (call == n) {
            StringBuilder sb = new StringBuilder();
            for (int x: numbers) {
                sb.append(x).append(' ');
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (count == 2 && prev == i) {
                continue;
            }

            numbers.add(i);
            if (prev == i) solve(call + 1, i, count + 1);
            else solve(call + 1, i, 1);
            numbers.remove(numbers.size() - 1);
        }
    }
}
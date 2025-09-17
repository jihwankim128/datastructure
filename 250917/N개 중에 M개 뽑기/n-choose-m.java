import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        solve(0, 1);
    }

    static void solve(int k, int next) {
        if (k >= m) {
            for (int x: numbers) {
                System.out.print(x + " ");
            }
            System.out.println();
            return ;
        }

        for (int i = next; i <= n; i++) {
            numbers.add(i);
            solve(k + 1, i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }
}
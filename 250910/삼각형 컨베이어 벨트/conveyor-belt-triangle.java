import java.util.Scanner;
public class Main {

    static int n, t;
    static int[] l, r, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        l = new int[n];
        r = new int[n];
        d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        System.out.println(solve());
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        
        // t초 동안 작업
        while (t-- > 0) {
            moveBelt();
        }

        for (int i = 0; i < n; i++) {
            sb.append(l[i]).append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(r[i]).append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(d[i]).append(' ');
        }

        return sb.toString();
    }

    static void moveBelt() {
        // left의 마지막 요소가 right의 첫번째 요소로 삽입된다.
        // right의 마지막 요소가 down의 첫번째 요소로 삽입된다.
        // down의 마지막 요소가 left의 첫번째 요소로 삽입된다.
        int lLast = l[n - 1], rLast = r[n - 1], dLast = d[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            l[i] = l[i - 1];
            r[i] = r[i - 1];
            d[i] = d[i - 1];
        }
        r[0] = lLast;
        d[0] = rLast;
        l[0] = dLast;
    }
}
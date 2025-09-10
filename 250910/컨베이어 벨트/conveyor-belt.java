import java.util.Scanner;
public class Main {

    static int n, t;
    static int[] top, bottom;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        top = new int[n];
        bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        
        System.out.println(solve());
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        // t초 동안 작업을 처리해야된다.
        while (t-- > 0) {
            moveBelt();
        }
        // 최종 결과를 출력한다.
        for (int i = 0; i < n; i++) {
            sb.append(top[i]).append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(bottom[i]).append(' ');
        }
        return sb.toString();
    }

    static void moveBelt() {
        // top의 마지막 요소가 bottom의 마지막 요소로 삽입된다.
        // bottom의 첫번째 요소가 top의 첫번째 요소로 삽입된다.
        int lastTop = top[n - 1];
        int firstBottom = bottom[n - 1];

        // top의 벨트가 오른쪽으로 한칸씩 이동한다.
        // bottom의 벨트가 왼쪽으로 한칸씩 이동한다.
        for (int i = n - 1; i >= 1; i--) {
            top[i] = top[i - 1];
            bottom[i] = bottom[i - 1];
        }

        bottom[0] = lastTop;
        top[0] = firstBottom;
    }
}
import java.util.Scanner;

public class Main {

    static String A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        
        System.out.println(solve());
    }

    static int solve() {
        int minLength = 100;
        // 문자열 길이만큼 오른쪽으로 shift 한다.
        for (int i = 0; i < A.length(); i++) {
            shift(i);
            // shift 한 결과에서 인코딩 결과의 길이를 구한다.
            int encodingSize = encode();
            // 인코딩 한 결과에서 가장 작은 길이를 구한다.
            minLength = Math.min(minLength, encodingSize);
        }
        return minLength;
    }

    static void shift(int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < A.length(); i++) {
            sb.append(A.charAt(i));
        }
        for (int i = 0; i < idx; i++) {
            sb.append(A.charAt(i));
        }
        A = sb.toString();
    }

    static int encode() {
        StringBuilder sb = new StringBuilder();
        char prev = A.charAt(0);
        int count = 1;

        for (int i = 1; i < A.length(); i++) {
            char now = A.charAt(i);
            if (prev == now) {
                count++;
            } else {
                sb.append(prev).append(count);
                prev = now;
                count = 1;
            }
        }
        sb.append(prev).append(count);
        return sb.length();
    }
}
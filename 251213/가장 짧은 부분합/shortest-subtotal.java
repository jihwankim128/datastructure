import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = -1;
        for (int p1 = 0, p2 = 0, sum =0; p1 < n; p1++) {
            sum += arr[p1];
            while (sum >= s) {
                if (ans == -1) ans = p1 - p2 + 1;
                else ans = Math.min(ans, p1 - p2 + 1);
                sum -= arr[p2++];
            }
        }
        System.out.println(ans);
    }
}
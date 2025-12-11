import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] coord = new int[200001];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            coord[x1]++;
            coord[x2]--;
        }
        
        int sum = 0, ans = 0;
        for (int i = 1; i <= 200000; i++) {
            sum += coord[i];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
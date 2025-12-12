import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);    
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pq.offer(new int[] {a, 1});
            pq.offer(new int[] {b, -1});
        }
        
        int sum = 0, ans = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll()[1];
            if (sum == 0) ans++;
        }
        System.out.println(ans);
    }
}
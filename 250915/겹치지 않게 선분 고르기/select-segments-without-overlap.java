import java.util.*;

public class Main {

    static class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static ArrayList<Pair> coordinate = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinate.add(new Pair(x, y));
        }
        
        solve();
    }

    static void solve() {
        coordinate.sort((p1, p2) -> {
            if (p1.x == p2.x) return p1.y - p2.y;
            return p1.x - p2.x;
        });
        
        Pair prev = coordinate.get(0);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            Pair now = coordinate.get(i);
            if (now.x <= prev.y) continue;
            prev = now;
            cnt++;
        }
        System.out.println(cnt);
    }
}
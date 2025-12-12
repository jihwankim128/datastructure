import java.util.*;
public class Main {

    static class Point {
        int x, v;
        Point (int x, int v) {
            this.x = x;
            this.v = v;
        }
    }

    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(x1, 1));
            points.add(new Point(x2, -1));
        }
        points.sort((p1, p2) -> p1.x - p2.x);
        
        System.out.println(getMaxCnt());
    }

    static int getMaxCnt() {
        int maxCnt = 0;
        int sum = 0;
        for (Point p: points) {
            sum += p.v;
            maxCnt = Math.max(maxCnt, sum);
        }
        return maxCnt;
    }
}
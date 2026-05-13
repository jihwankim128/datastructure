// 13:29
/*
1. 우선순위: 구슬 속도, 구슬 번호
*/
import java.util.*;
public class Main {

    static class Marble {
        int i;
        char d;
        int v;
        
        public Marble(int i, char d, int v) {
            this.i = i;
            this.d = d;
            this.v = v;
        }

        public void reverse() {
            if (d == 'L') d = 'R';
            else if (d == 'R') d = 'L';
            else if (d == 'U') d = 'D';
            else d = 'U';
        }
    }

    static int n, m, t, k;
    static int[][] delta = new int[128][2];
    static List<Marble>[][] marbles = new ArrayList[51][51];
    
    public static void main(String[] args) {
        delta['L'] = new int[]{0, -1};
        delta['R'] = new int[]{0, 1};
        delta['U'] = new int[]{-1, 0};
        delta['D'] = new int[]{1, 0};

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                marbles[i][j] = new ArrayList<>();
            }
        }

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            int v = sc.nextInt();
            marbles[r][c].add(new Marble(i, d, v));
        }

        while (t-- > 0) {
            List[][] temp = move();
            update(temp);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += marbles[i][j].size();
            }
        }
        System.out.println(cnt);
    }

    static void update(List<Marble>[][] temp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j].size() <= k) continue;

                temp[i][j].sort((m1, m2) -> {
                    if (m2.v == m1.v) {
                        return m2.i - m1.i;
                    }
                    return m2.v - m1.v;
                });
                    
                List<Marble> survived = new ArrayList<>(temp[i][j].subList(0, k));
                temp[i][j] = survived;
            }
        }

        marbles = temp;
    }

    static List<Marble>[][] move() {
        List<Marble>[][] temp = new List[51][51];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Marble marble : marbles[i][j]) {
                    int x = i;
                    int y = j;
                    int moveCount = marble.v % (2 * (n - 1));

                    for (int step = 0; step < moveCount; step++) {
                        int nx = x + delta[marble.d][0];
                        int ny = y + delta[marble.d][1];
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            marble.reverse();
                            nx = x + delta[marble.d][0];
                            ny = y + delta[marble.d][1];
                        }
                        x = nx;
                        y = ny;
                    }
                    
                    temp[x][y].add(marble);
                }
            }
        }
        return temp;
    }
}
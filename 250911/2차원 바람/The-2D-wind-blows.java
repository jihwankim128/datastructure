import java.util.Scanner;
public class Main {

    static int n, m, q;
    static int[][] building, queries, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        
        // 건물 정보
        building = new int[n][m];
        temp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();

        // 바람이 불면 영향을 받는 영역
        queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt();

        solve();
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(building[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static void solve() {
        // 각 영역에 대해 테두리 회전
        for (int i = 0; i < q; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            rotate(x1, y1, x2, y2);
            // 기존 결과를 저장
            copyBuilding();
            // 회전된 결과에 대해 각 영역의 값들을 인접한 값의 평균 값으로 동시에 업데이트
            changeBuilding(x1, y1, x2, y2);
        }
        print();
    }

    static void rotate(int x1, int y1, int x2, int y2) {
        int temp = building[x1][y1];
        // 아래서 위로
        for (int i = x1; i < x2; i++) {
            building[i][y1] = building[i + 1][y1];
        }
        // 오른쪽에서 왼쪽
        for (int i = y1; i < y2; i++) {
            building[x2][i] = building[x2][i + 1];
        }
        // 위에서 아래로
        for (int i = x2; i > x1; i--) {
            building[i][y2] = building[i - 1][y2];
        }
        // 왼쪽에서 오른쪽으로
        for (int i = y2; i > y1; i--) {
            building[x1][i] = building[x1][i - 1];
        }

        building[x1][y1 + 1] = temp;
    }

    static void copyBuilding() {
        // temp에 회전된 건물의 정보를 담음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = building[i][j];
            }
        }
    }

    static void changeBuilding(int x1, int y1, int x2, int y2) {
        // 회전된 빌딩 정보(temp)로 기존 빌딩 정보를 업데이트 
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                building[i][j] = calculateAvg(i, j);
            }
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int calculateAvg(int x, int y) {
        int sum = temp[x][y];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            // 실제 계산
            count++;
            sum += temp[nx][ny];
        }
        return sum / count;
    }
}
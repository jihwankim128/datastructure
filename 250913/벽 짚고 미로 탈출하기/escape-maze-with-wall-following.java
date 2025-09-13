// PM 11:04
import java.util.Scanner;

public class Main {

    static int n, x, y;
    static char[][] maze = new char[101][101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        
        solve();
    }

    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static boolean[][] visited = new boolean[101][101];

    static void debugging() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
    static void solve() {
        // 시작 방향을 오른쪽으로 한칸 이동한다.
        int dir = 3;
        visited[x][y] = true;
        int count = 0;
        
        // 벗어날 때까지 반복한다.
        while (true) { 
            //debugging();
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                break;
            }
            // 이동하는 방향이 만약 벽이라면 왼쪽으로 90도 회전한다.
            if (maze[nx][ny] == '#') {
                dir = (dir + 1) % 4;
                continue;
            }

            if (visited[nx][ny]) {
                count = -2;
                break;
            }
            // 이동하는 방향이 벽이 아니라면 앞으로 이동한다.
            visited[nx][ny] = true;
            x = nx;
            y = ny;
            count++;

            // 앞으로 이동 중 아래에 벽이 없으면 오른쪽 회전 후 벽의 측면을 따라 이동한다.
            int ndir = (dir + 3) % 4;
            nx = nx + dx[ndir];
            ny = ny + dy[ndir];
            if (maze[nx][ny] == '.') {  
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                dir = ndir;
                count++;
            };
        }

        System.out.println(count + 1);
    }
}
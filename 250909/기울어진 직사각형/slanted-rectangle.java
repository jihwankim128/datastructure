import java.util.Scanner;
public class Main {

    static int[][] grid = new int[21][21];
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        System.out.println(solve());
    }

    static int solve() {
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum = Math.max(maxSum, findMaxSum(i, j));
            }
        }
        return maxSum;
    }

    static int findMaxSum(int x, int y) {
        int maxSum = 0;
        for (int height = 1; height < n; height++) {
            for (int width = 1; width < n; width++) {
                // 직사각형을 그릴 수 있는지?
                if (canDraw(x, y, height, width)) {
                    maxSum = Math.max(maxSum, drawRect(x, y, height, width));
                }
            }
        }
        return maxSum;
    }

    static boolean canDraw(int lsx, int lsy, int height, int width) {
        // 왼쪽 시작점에서 왼쪽 끝점으로 내려갔을 때 범위 체크
        int lex = lsx + height, ley = lsy - height;
        if (lex >= n || ley < 0) return false;
        // 왼쪽 끝점에서 오른쪽 끝점으로 내려갈 때 범위 체크
        int rex = lex + width, rey = ley + width;
        if (rex >= n || rey >= n) return false;
        // 오른쪽 끝점에서 오른쪽 시작점으로 올라 갈 때 범위 체크
        int rsx = rex - height, rsy = rey + height;
        if (rsx < 0 || rsy >= n) return false;
        return true;
    }

    static int drawRect(int lsx, int lsy, int height, int width) {
        int lex = lsx + height, ley = lsy - height;
        int rex = lex + width, rey = ley + width;
        int rsx = rex - height, rsy = rey + height;
        
        int sum = 0;
        for (int i = 0; i < height; i++) sum += grid[lsx++][lsy--];
        for (int i = 0; i < width; i++) sum += grid[lex++][ley++];
        for (int i = 0; i < height; i++) sum += grid[rex--][rey++];
        for (int i = 0; i < width; i++) sum += grid[rsx--][rsy--];
        return sum;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // dp[i][j][k] = (i,j)에 최솟값 k로 도달했을 때의 최댓값
        // 값 범위: 0~100
        int[][][] dp = new int[n][n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], 101);  // 불가능한 큰 값
            }
        }
        
        dp[0][0][grid[0][0]] = grid[0][0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int minVal = 0; minVal <= 100; minVal++) {
                    if (dp[i][j][minVal] == 101) continue;  // 도달 불가능
                    
                    int maxVal = dp[i][j][minVal];
                    
                    // 오른쪽
                    if (j + 1 < n) {
                        int newMin = Math.min(minVal, grid[i][j+1]);
                        int newMax = Math.max(maxVal, grid[i][j+1]);
                        dp[i][j+1][newMin] = Math.min(dp[i][j+1][newMin], newMax);
                    }
                    
                    // 아래
                    if (i + 1 < n) {
                        int newMin = Math.min(minVal, grid[i+1][j]);
                        int newMax = Math.max(maxVal, grid[i+1][j]);
                        dp[i+1][j][newMin] = Math.min(dp[i+1][j][newMin], newMax);
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int minVal = 0; minVal <= 100; minVal++) {
            if (dp[n-1][n-1][minVal] != 101) {
                ans = Math.min(ans, dp[n-1][n-1][minVal] - minVal);
            }
        }
        
        System.out.println(ans);
    }
}
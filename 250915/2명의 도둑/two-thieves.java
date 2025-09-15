// pm 03:07 ~ 

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n, m, c, ans;
    static int[][] grid;
    static ArrayList<Integer> orders = new ArrayList<>();

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int k, int idx) {
        // 기저 조건
        if (k == 2) {
            // 도둑 간 m 구간이 안 겹치도록
            int firstRow = orders.get(0);
            int secondRow = orders.get(1); 
            
            // 각 구간 별로 도둑질이 가능한지 확인
        
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    // 같은 행이면 구간이 겹치지 않는지 확인
                    if (firstRow == secondRow && Math.abs(i - j) < m) continue;
                    
                    int w1 = steal(firstRow, i);
                    int w2 = steal(secondRow, j);
                    ans = Math.max(ans, w1 + w2);
                }
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            orders.add(i);
            solve(k + 1, i);
            orders.remove(orders.size() - 1);
        }
    }

    static int steal(int row, int startCol) {
        // m개의 물건 중에서 무게 c를 초과하지 않으면서 가치 최대화
        ArrayList<Integer> items = new ArrayList<>();
        for (int i = startCol; i < startCol + m; i++) {
            items.add(grid[row][i]);
        }

        return backtrack(items, 0, 0, 0); // 매개변수 하나 더 추가 (현재 가치)
    }

    static int backtrack(ArrayList<Integer> items, int idx, int currentWeight, int currentValue) {
        // 기저 조건: 모든 아이템 검토 완료
        if (idx == items.size()) {
            return currentValue; // 가치 합 반환
        }
        
        int maxValue = 0;
        
        // 현재 아이템을 선택하지 않는 경우
        maxValue = Math.max(maxValue, backtrack(items, idx + 1, currentWeight, currentValue));
        
        // 현재 아이템을 선택하는 경우 (용량 초과하지 않을 때만)
        if (currentWeight + items.get(idx) <= c) {
            int item = items.get(idx);
            maxValue = Math.max(maxValue, 
                backtrack(items, idx + 1, currentWeight + item, currentValue + item * item));
        }
        
        return maxValue;
    }
}
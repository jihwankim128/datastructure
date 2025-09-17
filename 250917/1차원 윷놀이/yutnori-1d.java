import java.util.Scanner;
public class Main {

    static int n, m, k, maxScore;
    static int[] nums, horses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt() - 1;
        k = sc.nextInt();
        nums = new int[n];
        horses = new int[4];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        solve(0, 0);
        System.out.println(maxScore);
    }

    static void solve(int pos, int score) {
        if (pos >= n) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        // 말을 이동해야 됨.
        for (int horse = 0; horse < k; horse++) {
            // 현재 말이 이미 m 만큼 이동했으면 넘어감
            if (horses[horse] >= m) continue;
            
            // 현재 거리에 따라 말을 이동
            horses[horse] += nums[pos];
            if (horses[horse] >= m) solve(pos + 1, score + 1);
            else solve(pos + 1, score);
            horses[horse] -= nums[pos];
        }
    }
}
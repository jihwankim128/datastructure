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

        // 각 말에게 현재 숫자를 주는 경우
        for (int horse = 0; horse < k; horse++) {
            int newScore = score;
            if (horses[horse] < m && horses[horse] + nums[pos] >= m) newScore++;

            horses[horse] += nums[pos];
            solve(pos + 1, newScore);
            horses[horse] -= nums[pos];
        }
    }
}
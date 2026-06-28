import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrA = new int[1000001];
        int[] arrB = new int[1000001];

        int timeA = 1;
        int timeB = 1;

        for(int i=0; i<n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
        
            for(int j=0; j<t; j++){
                arrA[timeA] = arrA[timeA-1] + v;
                timeA++;
            }
        }

        for(int i=0; i<m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            for(int j=0; j<t; j++){
                arrB[timeB] = arrB[timeB-1] + v;
                timeB++;
            }
        }


        int ans = 0;
        int previousLeader = 0;

        for (int i = 1; i < timeA; i++) {
            int currentLeader = 0;

            if (arrA[i] > arrB[i]) {
                currentLeader = 1;
            } else if (arrA[i] < arrB[i]) {
                currentLeader = -1;
            }

            // 공동 선두면 마지막 단독 선두 정보를 유지
            if (currentLeader == 0) {
                continue;
            }

            // 처음 단독 선두가 생긴 것은 변경이 아님
            if (previousLeader != 0 && previousLeader != currentLeader) {
                ans++;
            }

            previousLeader = currentLeader;
            }
        System.out.println(ans);
        
    }
}

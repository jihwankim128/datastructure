//속도, 시간 입력받기
//

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];

        int[] resA = new int[1000001];
        int[] resB = new int[1000001];

        int indexA = 1;
        int indexB = 1;

        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt(); //A의 속도
            a[i][1] = sc.nextInt(); //A의 시간

            totalTime += a[i][1];

            for(int j=0; j<a[i][1]; j++){
                resA[indexA] = resA[indexA-1] + a[i][0];
                indexA++;
            }

        }

        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt(); //B의 속도
            b[i][1] = sc.nextInt(); //B의 시간

            for(int j=0; j<b[i][1]; j++){
                resB[indexB] = resB[indexB-1] + b[i][0];
                indexB++;
            }
        }

        int prev = 0; //처음엔 같은 선상에서 출발하므로 우선 0으로 초기화. 
        //prev=0이면 이전에 A,B 동률.
        //prev=1이면 이전에 A가 앞선상태.
        //prev=2이면 이전에 B가 앞선상태.

        int count = 0;

        for(int i=1; i<=totalTime; i++){
            if(resA[i]>resB[i]){
                if(prev!=1){
                    count++;
                }

                prev=1;
            }
            else if(resB[i]>resA[i]){
                if(prev!=2){
                    count++;
                }
                prev = 2;
            }
            else if(resA[i]==resB[i]){
                if(prev!=0){
                    count++;
                }

                prev=0;
            }
        }
        
        System.out.println(count);

    }
}

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

        int leader = 0, ans = 0;
        for(int i=1; i<timeA; i++){
            if(arrA[i]>arrB[i]){
                if(leader==2){
                    ans++;
                }
                leader=1;
            }
            else if(arrB[i]>arrA[i]){
                if(leader==1){
                    ans++;
                }
                leader=2;
            }
        }

        
        System.out.println(ans);
        
    }
}

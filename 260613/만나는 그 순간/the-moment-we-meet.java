import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrA = new int[1000001];
        int[] arrB = new int[1000001];

        int curTimeA=1;
        int curTimeB=1;

        for(int i=0; i<n; i++){
            char direction = sc.next().charAt(0);
            int num = sc.nextInt();

            for(int j=0; j<num; j++){
                if(direction=='R'){
                    arrA[curTimeA] = arrA[curTimeA-1] + 1;
                }
                else{
                    arrA[curTimeA] = arrA[curTimeA-1] - 1;
                }
                curTimeA++;
            }
            
        }
        for(int i=0; i<m; i++){
            char direction = sc.next().charAt(0);
            int num = sc.nextInt();

            for(int j=0; j<num; j++){
                if(direction=='R'){
                    arrB[curTimeB] = arrB[curTimeB-1]+1;
                }
                else{
                    arrB[curTimeB] = arrB[curTimeB-1]-1;
                }
                curTimeB++;
            }
        }

        int sameTime = 0;
        for(int i=1; i<=1000000; i++){

            if(arrA[i]==arrB[i] && arrA[i]!=0){
                sameTime = i;
                break;
            }
            sameTime=-1;
        }
        
        System.out.println(sameTime);
    }
}

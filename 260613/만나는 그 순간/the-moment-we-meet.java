import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrA = new int[2000001];
        int[] arrB = new int[2000001];
        int positionA = 1000000;
        int positionB = 1000000;

        int curTimeA=0;
        int curTimeB=0;

        for(int i=0; i<n; i++){
            char direction = sc.next().charAt(0);
            int num = sc.nextInt();

            if(direction=='R'){
                for(int j=0; j<=num; j++){
                    arrA[curTimeA]=positionA;
                    positionA++;
                    curTimeA++;
                }
                curTimeA--;
                positionA--;
            }
            else{
                for(int j=0; j<=num; j++){
                    arrA[curTimeA]=positionA;
                    positionA--;
                    curTimeA++;
                }
                curTimeA--;
                positionA++;
            }
            
        }
        for(int i=0; i<m; i++){
            char direction = sc.next().charAt(0);
            int num = sc.nextInt();

            if(direction=='R'){
                for(int j=0; j<=num; j++){
                    arrB[curTimeB]=positionB;
                    positionB++;
                    curTimeB++;
                }
                curTimeB--;
                positionB--;
            }
            else{
                for(int j=0; j<=num; j++){
                    arrB[curTimeB]=positionB;
                    positionB--;
                    curTimeB++;
                }
                curTimeB--;
                positionB++;
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

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrA = new int[2000000];
        int[] arrB = new int[2000000];
        int offset = 1000000;
        int positionA = 0;
        int positionB = 0;
        int indexA = 0;
        int indexB = 0;

        for(int i=0; i<n; i++){
            char dir = sc.next().charAt(0); //이거 맞는지 체크
            int t = sc.nextInt();
            if(dir=='R'){
                for(int j=0; j<=t; j++){
                    arrA[indexA] = positionA + offset;
                    positionA++;
                    indexA++;
                }
                positionA--;
                indexA--;
            }
            else{
                for(int j=0; j<=t; j++){
                    arrA[indexA] = positionA + offset; 
                    positionA--;
                    indexA++;
                }
                positionA++;
                indexA--;
            }
        }

        for(int i=0; i<m; i++){
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();
            if(dir=='R'){
                for(int j=0; j<=t; j++){
                    arrB[indexB] = positionB + offset;
                    positionB++;
                    indexB++;
                }
                positionB--;
                indexB--;
            }
            else{  
                for(int j=0; j<=t; j++){
                    arrB[indexB] = positionB + offset;
                    positionB--;
                    indexB++;
                }
                positionB++;
                indexB--;
            }
        }

        int ans = 0;
        for(int i=0;i<2000000;i++){
            if(i>=1 && arrA[i]==arrB[i] && arrA[i]!=0){
                ans=i;
                break;
            
            }
            else{
                ans=-1;
            }
        }
        System.out.println(ans);

    }
}

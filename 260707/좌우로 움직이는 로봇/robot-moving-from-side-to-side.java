import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int offset = 2000000;

        int[] arrA = new int[2000001];
        Arrays.fill(arrA,2000000);
        int[] arrB = new int[2000001];
        Arrays.fill(arrB,2000000);

        int timeA = 1;
        int timeB = 1;

        for(int i=0; i<n; i++){
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for(int j=0; j<t; j++){
                if(d=='L'){
                    arrA[timeA] = arrA[timeA-1] -1;
                }
                else{
                    arrA[timeA] = arrA[timeA-1] +1;
                }
                timeA++;
            }
        }

        for(int i=0; i<m; i++){
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for(int j=0; j<t; j++){
                if(d=='L'){
                    arrB[timeB] = arrB[timeB-1] -1;
                }
                else{
                    arrB[timeB] = arrB[timeB-1] +1;
                }
                timeB++;
            }
        }

        int ans = 0;

        if(timeA>=timeB){
            for(int i=1; i<timeB; i++){
                if(arrA[i]==arrB[i] && arrA[i-1]!=arrB[i-1]){
                    ans++;
                }
            }
            for(int i=timeB; i<timeA; i++){
                if(arrA[i]==arrB[timeB-1] && arrA[i-1]!=arrB[timeB-1]){
                    ans++;
                }
            }
        }
        else{
            for(int i=1; i<timeA; i++){
                if(arrA[i]==arrB[i] && arrA[i-1]!=arrB[i-1]){
                    ans++;
                }
            }
            for(int i=timeA; i<timeB; i++){
                if(arrB[i]==arrA[timeA-1] && arrB[i-1]!=arrA[timeA-1]){
                    ans++;
                }
            }
        }
    
        System.out.println(ans);
    }
}
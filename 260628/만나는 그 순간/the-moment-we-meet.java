import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrA = new int[2000000];
        int[] arrB = new int[2000000];

        int indexA = 1;
        int indexB = 1;

        for(int i=0; i<n; i++){
            char dir = sc.next().charAt(0); //이거 맞는지 체크
            int t = sc.nextInt();
            for(int j=0; j<t; j++){
                if(dir=='R'){
                    arrA[indexA] = arrA[indexA-1] +1;
                }
                else{
                    arrA[indexA] = arrA[indexA-1] -1;
                }
                indexA++;
            }


        }

        for(int i=0; i<m; i++){
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();

            for(int j=0;j<t; j++){
                if(dir=='R'){
                    arrB[indexB] = arrB[indexB-1]+1;
                }  
                else{
                    arrB[indexB] = arrB[indexB-1]-1;
                }
                indexB++;
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

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[200][200];

        int n = sc.nextInt();
        int offset = 100;
        for(int i=0; i<n; i++){
            int x1 = sc.nextInt() + offset;
            int y1 = sc.nextInt() + offset;
            int x2 = sc.nextInt() + offset;
            int y2 = sc.nextInt() + offset;
            
            for(int j=x1; j<x2; j++){
                for(int k=y1; k<y2; k++){
                    arr[j][k]+=1;
                }
            }
        }

        int res = 0;
        for(int i=0;i<200;i++){
            for(int j=0;j<200;j++){
                if(arr[i][j]>0){
                    res+=1;
                }
            }
        }
        System.out.println(res);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[200][200];
        int offset = 100;


        for(int i=0; i<n; i++){
            int x1 = sc.nextInt() + offset;
            int y1 = sc.nextInt() + offset;
            for(int j=x1; j<x1+8; j++){
                for(int k=y1; k<y1+8; k++){
                    arr[j][k]+=1;
                }
            }
        }

        int area = 0;

        for(int i=0; i<200; i++){
            for(int j=0; j<200; j++){
                if(arr[i][j]>0){
                    area+=1;
                }
            }
        }
        System.out.println(area);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2000][2000];
        int offset = 1000;

        for(int i=0; i<2; i++){
            int x1 = sc.nextInt() + offset;
            int y1 = sc.nextInt() + offset;
            int x2 = sc.nextInt() + offset;
            int y2 = sc.nextInt() + offset;

            for(int j = x1; j<x2; j++){
                for(int k=y1; k<y2; k++){
                    arr[j][k]+=1;
                }
            }   
        }
        int x1 = sc.nextInt() + offset;
        int y1 = sc.nextInt() + offset;
        int x2 = sc.nextInt() + offset;
        int y2 = sc.nextInt() + offset;
        for(int i = x1; i<x2; i++){
            for(int j=y1; j<y2; j++){
                arr[i][j]-=1;
            }
        }

        int area = 0;

        for(int i=0; i<2000; i++){
            for(int j=0; j<2000; j++){
                if(arr[i][j]==1){
                    area+=1;
                }
            }
        }
        System.out.println(area);
    }
}
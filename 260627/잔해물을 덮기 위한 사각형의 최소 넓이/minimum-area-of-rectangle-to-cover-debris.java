import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][]arr = new int[2000][2000];
        int offset = 1000;
        int[] x1 = new int[2];
        int[] y1 = new int[2];
        int[] x2 = new int[2];
        int[] y2 = new int[2];

        for(int i=0; i<2; i++){
            x1[i] = sc.nextInt() + offset;
            y1[i] = sc.nextInt() + offset;
            x2[i] = sc.nextInt() + offset;
            y2[i] = sc.nextInt() + offset;
            if(i==0){
                for(int j=x1[0]; j<x2[0]; j++){
                    for(int k=y1[0]; k<y2[0]; k++){
                        arr[j][k]=1;
                
                    }
                }
            }
            else{
                for(int j=x1[1]; j<x2[1]; j++){
                    for(int k=y1[1]; k<y2[1]; k++){
                        arr[j][k]=2;
                    }
                }
            }
        }
        
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        boolean isFirstX = true;
        boolean isFirstY = true;
        for(int i=x1[0]; i<x2[0]; i++){
            for(int j=y1[0]; j<y2[0]; j++){
                if(arr[i][j]==1){
                    if(isFirstX){
                        minX = i;
                        isFirstX = false;
                    }
                    if(isFirstY){
                        minY = j;
                        isFirstY = false;
                    }
                    maxX = Math.max(maxX,i); //이부분 maxX = i;
                    maxY = Math.max(maxY,j);// maxY = j; 로 해서 틀렸었음.
                }
            }
        }

        if(minX==maxX && minY==maxY){
            System.out.println(0);
        }
        else{
            System.out.println((maxX-minX+1)*(maxY-minY+1));
        }

    }
}

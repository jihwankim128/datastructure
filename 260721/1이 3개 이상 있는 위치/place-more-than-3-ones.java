import java.util.*;

public class Main {

    public static boolean inRange(int x, int y, int n){
        return (0 <= x && x < n && 0 <= y && y<n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int res = 0;


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int count = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(inRange(nx,ny,n) && arr[nx][ny]==1){
                        count++;
                    }
                }
                if(count>=3){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

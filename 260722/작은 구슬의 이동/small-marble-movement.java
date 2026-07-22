import java.util.*;

import java.util.Scanner;

public class Main {

    public static boolean inRange(int x, int y, int n){
        return (0<x && x<=n && 0<y && y<=n);
    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        char d = sc.next().charAt(0);

        int[][] arr = new int[n+1][n+1];

        int[] dx = new int[]{0,1,0,-1}; //우 하 좌 상 0 1 2 3
        int[] dy = new int[]{1,0,-1,0}; 
        
        int x = r;
        int y = c;

        int dir;

        if(d=='R'){
            dir = 0;
        }
        else if(d=='D'){
            dir = 1;
        }
        else if(d=='L'){
            dir = 2;
        }
        else{
            dir = 3;
        }

        for(int i=0; i<t; i++){
            int nx = x + dx[dir], ny = y + dy[dir];

            if(!inRange(nx,ny,n)){
                dir = (dir + 2) % 4;    
                continue;
            }

            x = nx;
            y = ny;
        }
        System.out.printf("%d %d",x ,y);
    }
}

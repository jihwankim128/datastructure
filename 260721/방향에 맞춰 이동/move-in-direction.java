import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,-1,0,1};

        int x = 0;
        int y = 0;

        for(int i=0; i<n; i++){
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            int dir;
            if(direction=='E'){
                dir=0;
            }
            else if(direction=='S'){
                dir=1;
            }
            else if(direction=='W'){
                dir=2;
            }
            else{
                dir=3;
            }

            for(int j=0; j<distance; j++){
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }
        
        System.out.printf("%d %d",x,y);
    }
}

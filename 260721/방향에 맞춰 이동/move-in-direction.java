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
            
            for(int j=0; j<distance; j++){
                if(direction=='E'){
                    x += dx[0];
                    y += dy[0];
                }
                else if(direction=='S'){
                    x += dx[1];
                    y += dy[1];
                }
                else if(direction=='W'){
                    x += dx[2];
                    y += dy[2];
                }
                else if(direction=='N'){
                    x += dx[3];
                    y += dy[3];
                }
            }
        }
        
        System.out.printf("%d %d",x,y);
    }
}
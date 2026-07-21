import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dir = sc.next();

        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,-1,0,1};

        int x=0;
        int y=0;

        int iDir = 3;
        for(int i=0; i<dir.length(); i++){
            if(dir.charAt(i)=='L'){ 
                iDir = (iDir-1 + 4) % 4;
            }
            else if(dir.charAt(i)=='R'){
                iDir = (iDir+1) % 4;
            }

            else{
                x = x + dx[iDir];
                y = y + dy[iDir];
            }
        }

        System.out.printf("%d %d",x,y); 
    }
}

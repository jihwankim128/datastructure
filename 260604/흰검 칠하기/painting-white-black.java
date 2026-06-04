import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] white = new int[200001];
        int[] black = new int[200001];
        int[] res = new int[200001];
        
        int position = 100000;

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            char direction = sc.next().charAt(0);

            if(direction=='R'){
                for(int j=0; j<num; j++){
                    black[position]+=1;
                    res[position]=-1; // 검은색
                    position++;
                }
                position--;
            }
            else{
                for(int j=0; j<num; j++){
                    white[position]+=1;
                    res[position]=-2;//흰색
                    position--;
                }
                position++;
            }

        }

        for(int i=0; i<=200000; i++){
            if(white[i]>=2 && black[i]>=2){
                res[i]=-3; //회색
            }
        }

        int whiteCount = 0;
        int blackCount = 0;
        int grayCount = 0;

        for(int i=0; i<=200000; i++){
            if(res[i]==-1){
                blackCount++;
            }
            else if(res[i]==-2){
                whiteCount++;
            }
            else if(res[i]==-3){
                grayCount++;
            }
        }

        System.out.printf("%d %d %d",whiteCount,blackCount,grayCount);
    }
}
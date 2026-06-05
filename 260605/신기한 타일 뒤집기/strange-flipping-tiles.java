import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[200001];
        int position = 100000;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            char direction = sc.next().charAt(0);

            if(direction=='R'){
                for(int j=0;j<num;j++){
                    arr[position] = 1; //검은색
                    position++;   
                }
                position--;
            }
            else{
                for(int j=0;j<num;j++){
                    arr[position] = 2; //흰색
                    position--;
                }
                position++;
            }
        }
        int whiteCount = 0;
        int blackCount = 0;
        for(int i=0; i<=200000; i++){
            if(arr[i]==1){
                blackCount++;
            }
            else if(arr[i]==2){
                whiteCount++;
            }
        }
        System.out.printf("%d %d",whiteCount,blackCount);
    }
}
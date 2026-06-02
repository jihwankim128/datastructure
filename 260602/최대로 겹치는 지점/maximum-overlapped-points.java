import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[101];

        for(int i=0; i<n; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            for(int j=from; j<=to; j++){
                arr[j]+=1;
            }
        }
        int maxValue=0;
        for(int i=1;i<=100;i++){
            if(maxValue<arr[i]){
                maxValue=arr[i];
            }
        }

        System.out.println(maxValue);
    }
}
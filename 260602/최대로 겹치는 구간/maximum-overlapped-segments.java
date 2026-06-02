import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[201];

        for(int i=0; i<n; i++){
            int from = sc.nextInt();
            from+=100;
            int to = sc.nextInt();
            to+=100;
            for(int j=from; j<to; j++){
                arr[j]+=1;
            }
        }

        int maxValue = 0;
        for(int i=0; i<201; i++){

            if(maxValue<arr[i]){
                maxValue=arr[i];
            }
        }
        System.out.println(maxValue);
    }
}
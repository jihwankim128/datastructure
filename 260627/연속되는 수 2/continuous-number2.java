import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int count=1;
        int maxCount=0;
        for(int i=0; i<n; i++){
            if(i==0){
                count=1;
            }
            else if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                if(maxCount<count){
                    maxCount=count;
                }
                count=1;
            }
        }
        if(maxCount<count){
            maxCount=count;
        }
        System.out.println(maxCount);
    }
}
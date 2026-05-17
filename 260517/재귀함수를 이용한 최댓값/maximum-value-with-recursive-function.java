import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(rec(arr,n-1,arr[n-1]));
    }

    public static int rec(int[] arr, int n, int maxValue){
        
        if(n==0){
            return Math.max(arr[0],maxValue);
        }
        else{
            int maxVal = Math.max(maxValue,arr[n-1]);
            return rec(arr,n-1,maxVal);
        }
    }
}
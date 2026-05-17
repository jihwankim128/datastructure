import java.util.Scanner;
public class Main {

    public static int MAX_N = 100;
    public static int[] arr = new int[MAX_N];    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(rec(n));
        
    }

    public static int rec(int n){
        if(n==0){
            return arr[0];
        }
        return Math.max(rec(n-1),arr[n]);
    }
}
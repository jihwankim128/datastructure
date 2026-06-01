import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = 0;
        }
        for(int i=0; i<k; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            for(int j=from; j<=to; j++){
                arr[j]+=1;
            }
        }

        int maxVal = 0;
        for(int i=1; i<=n; i++){
            if(arr[i]>=maxVal){
                maxVal = arr[i];
            }
        }
        System.out.println(maxVal);
    }
}
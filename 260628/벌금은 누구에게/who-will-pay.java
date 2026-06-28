import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[]arr = new int[n+1];

        int ans = -1;
        for(int i=0; i<m; i++){
            int num = sc.nextInt();
            arr[num]+=1;
            if(arr[num]>=k){
                ans = num;
                break;
            }
        }
        System.out.println(ans);

    }
}
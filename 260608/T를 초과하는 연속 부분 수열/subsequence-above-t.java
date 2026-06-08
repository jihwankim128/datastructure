import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];
        int cnt = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i]>t){
                cnt++;
            }
            else{
                cnt=0;
            }
            ans = Math.max(ans,cnt);
        }

        System.out.println(ans);

    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt=0;
        int ans=0;
        for(int i=0; i<n; i++){
            if(i>=1 && arr[i]==arr[i-1]){
                cnt++;
            }
            else{
                cnt=1;
            }
            ans = Math.max(cnt,ans);
        }

        System.out.println(ans);
    }
}
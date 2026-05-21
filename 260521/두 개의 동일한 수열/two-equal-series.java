import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        if(isSame(a,b,n)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static boolean isSame(int[] a, int[] b, int n){
        boolean isSame = true;

        for(int i=0; i<n; i++){
            if(a[i]!=b[i]){
                isSame = false;
                break;
            }
        }
        return isSame;
    }
}
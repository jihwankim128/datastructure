import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rec(n));
    }

    public static int rec(int n){
        if(n==1){
            return 1;
        }
        return n+rec(n-1);
    }
}
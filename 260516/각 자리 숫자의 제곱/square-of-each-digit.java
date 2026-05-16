import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(rec(n));
    }

    public static int rec(int n){
        if(n<10){
            return n*n;
        }
        return rec(n/10) + (n%10)*(n%10);
    }
}

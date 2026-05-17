import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rec(n));
    }

    public static int rec(int n){

        if(n==1){
            return 0;
        }

        if(n%2==0){
            return rec(n/2) + 1;
        }
        else{
            return rec(n/3) + 1;
        }
    }
}
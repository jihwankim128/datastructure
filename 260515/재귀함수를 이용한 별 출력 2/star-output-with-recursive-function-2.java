import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rec(n);
    }
    public static void rec(int n){
        if(n==0){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("* ");
        }
        System.out.println(sb);
        rec(n-1);
        System.out.println(sb);
    }
}
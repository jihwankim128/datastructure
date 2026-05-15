import java.util.Scanner;
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
        rec(n-1);
        for(int i=0; i<n; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
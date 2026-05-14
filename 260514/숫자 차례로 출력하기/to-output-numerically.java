import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        rec1(n);
        System.out.println();
        rec2(n);        
    }

    public static void rec1(int n){
        if(n==0){
            return;
        }
        rec1(n-1);
        System.out.print(n + " ");
    }

    public static void rec2(int n){
        if(n==0){
            return;
        }
        System.out.print(n + " ");
        rec2(n-1);
    }
}

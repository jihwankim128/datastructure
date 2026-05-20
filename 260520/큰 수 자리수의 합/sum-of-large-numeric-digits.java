import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int n = a*b*c;
        System.out.println(rec(n));
    }

    public static int rec(int n){
        if(n<10){
            return n;
        }
        return rec(n/10) + n%10;
    }
}
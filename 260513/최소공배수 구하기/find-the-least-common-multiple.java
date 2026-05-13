import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int gcd = gcd(n,m);
        int lcm = n*m/gcd;
        System.out.println(lcm);
    }

    public static int gcd(int a, int b){
        while(b!=0){
            int temp = a%b; // a%b -> 2
            a = b; // a=4
            b=temp;
        }
        return a;
    }
}
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int temp = n;
        n = m;
        m = temp;
        System.out.printf("%d %d",n,m);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = 0;

        if(a==11 && b<11){
            System.out.println(-1);
            return;
        }
        if(a==11 && b==11 && c<11){
            System.out.println(-1);
            return;
        }
        else{
            sum+=a*60*24;
            sum+=b*60;
            sum+=c;

            sum-=11*60*24;
            sum-=11*60;
            sum-=11;
            System.out.println(sum);
        }
    }
}
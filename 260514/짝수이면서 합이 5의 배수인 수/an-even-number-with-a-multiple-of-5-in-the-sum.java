import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(func(n));
    }

    public static String func(int n){
        int sum = 0;
        if(n%2==0){
            sum = n%10 + n/10;
            if(sum % 5 ==0){
                return "Yes";
            }
            else{
                return "No";
            }
        }
        else{
            return "No";
        }
    }
}
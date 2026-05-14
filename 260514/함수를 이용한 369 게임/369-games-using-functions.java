import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(func(A,B));
    }

// 4 ~ 20 -> 6,9,13,16,19
    public static int func(int a, int b){
        int sum = 0;

        for(int i=a;i<=b;i++){
            String value = String.valueOf(i);

            if(i%3==0){
                sum+=1;
            }

            else if(value.contains("3") || value.contains("6") || value.contains("9")){
                sum+=1;
            }
        }
        return sum;
    }
}
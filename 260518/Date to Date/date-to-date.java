import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] numOfMonth = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        int sum = 0;
        for(int i=1;i<m2;i++){
            sum+=numOfMonth[i];
        }
        sum+=d2;
        for(int i=1;i<m1;i++){
            sum-=numOfMonth[i];
        }
        sum-=d1;
        System.out.println(sum+1);

    }
}
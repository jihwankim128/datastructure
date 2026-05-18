import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] dayOfMonth = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] days = new String[]{"Mon","Sun","Sat","Fri","Thu","Wed","Tue"};

        int sum = 0;
        for(int i=0; i<m1; i++){
            sum+=dayOfMonth[i];
        }
        sum+=d1;
        for(int i=0; i<m2; i++){
            sum-=dayOfMonth[i];
        }
        sum-=d2;

        sum = sum%7;
        if(sum>=0){
            System.out.println(days[sum]);
        }
        else{
            System.out.println(days[days.length+sum]);
        }
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[2001];
        int position = 1000;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            String direction = sc.next();

            if(direction.equals("R")){
                for(int j=0; j<num; j++){
                    arr[position]+=1;
                    position++;
                }
            }
            else{
                for(int j=0; j<num; j++){
                    position--;
                    arr[position]+=1;
                }
            }
        }
        int area = 0;
        for(int i=0; i<=2000; i++){
            if(arr[i]>=2){
                area+=1;
            }
        }
        
        System.out.println(area);
    }
}
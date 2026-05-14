import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++){ 
            arr.add(Integer.parseInt(st.nextToken()));
        }

        arr.sort((a,b)->a-b);

        for(int i=0;i<n;i++){
            System.out.print(arr.get(i) + " ");
        }

        System.out.println();

        arr.sort((a,b)->b-a);
        
        for(int i=0;i<n;i++){
            System.out.print(arr.get(i) + " ");
        }
        
    }
}
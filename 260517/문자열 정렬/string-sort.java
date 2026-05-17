import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }
}

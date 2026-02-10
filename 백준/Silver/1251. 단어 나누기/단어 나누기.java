import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                String s3 = s.substring(j);

                String r1 = new StringBuilder(s1).reverse().toString();
                String r2 = new StringBuilder(s2).reverse().toString();
                String r3 = new StringBuilder(s3).reverse().toString();

                list.add(r1 + r2 + r3);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
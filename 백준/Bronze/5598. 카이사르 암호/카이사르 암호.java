import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c -= 3;
            if (c < 'A') {
                c += 26;
            }
            sb.append(c);
        }
        
        System.out.println(sb);
    }
}
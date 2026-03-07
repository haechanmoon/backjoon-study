import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String plain = br.readLine();
        String key = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < plain.length(); i++) {
            char p = plain.charAt(i);
            
            if (p == ' ') {
                sb.append(' ');
                continue;
            }
            
         
            char k = key.charAt(i % key.length());
         
            int diff = p - k;
         
            if (diff <= 0) {
                sb.append((char) (diff + 26 + 'a' - 1));
            } else {
                sb.append((char) (diff + 'a' - 1));
            }
        }
        
        System.out.println(sb);
    }
}
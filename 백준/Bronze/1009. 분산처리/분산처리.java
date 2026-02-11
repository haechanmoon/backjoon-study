import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int result = 1;
            
            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
            }
            
            if (result == 0) {
                sb.append(10).append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
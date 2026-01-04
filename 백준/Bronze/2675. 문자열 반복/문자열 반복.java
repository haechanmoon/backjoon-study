import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String input = st.nextToken();
            for(int j = 0 ; j<input.length();j++){
                char star = input.charAt(j);
                sb.append(String.valueOf(star).repeat(Math.max(0, a)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int temp = (N / 100) * 100;
        
        while (true) {
            if (temp % F == 0) {
                int result = temp % 100;
                System.out.printf("%02d", result);
                break;
            }
            temp++;
        }
    }
}
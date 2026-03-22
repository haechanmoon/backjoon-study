import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());

            int quarter = C / 25;
            C %= 25;

            int dime = C / 10;
            C %= 10;

            int nickel = C / 5;
            C %= 5;

            int penny = C;

            sb.append(quarter).append(" ")
              .append(dime).append(" ")
              .append(nickel).append(" ")
              .append(penny).append("\n");
        }
        System.out.print(sb);
    }
}
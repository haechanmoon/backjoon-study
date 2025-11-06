import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int sumString(String s) {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(s, "+");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, "-");

        int result = 0;

        if (st.hasMoreTokens()) {
            result = sumString(st.nextToken());
        }

        while (st.hasMoreTokens()) {
            result -= sumString(st.nextToken());
        }

        System.out.println(result);
    }
}
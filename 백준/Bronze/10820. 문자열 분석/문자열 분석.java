import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int digit = 0;
            int space = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= 'a' && c <= 'z') lower++;
                else if (c >= 'A' && c <= 'Z') upper++;
                else if (c >= '0' && c <= '9') digit++;
                else if (c == ' ') space++;
            }

            String sb = lower + " "
                    + upper + " "
                    + digit + " "
                    + space;

            System.out.println(sb);
        }
    }
}
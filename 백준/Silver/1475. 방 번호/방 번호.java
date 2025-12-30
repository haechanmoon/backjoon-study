import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] count = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            if (num == 9) {
                count[6]++;
            } else {
                count[num]++;
            }
        }

        count[6] = (count[6] + 1) / 2;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.println(max);
    }
}
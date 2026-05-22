import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
       
        if (s.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            
            if (i == 0) {
                sb.append(Integer.toBinaryString(digit));
            } else {
                sb.append(binary[digit]);
            }
        }
        
        System.out.println(sb);
    }
}
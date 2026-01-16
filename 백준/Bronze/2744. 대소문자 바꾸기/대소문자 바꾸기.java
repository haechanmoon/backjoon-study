import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isUpperCase(c)) {
                arr[i] = Character.toLowerCase(c);
            } else {
                arr[i] = Character.toUpperCase(c);
            }
        }

        System.out.println(new String(arr));
    }
}
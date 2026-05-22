import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        
        int count = 0;
        int i = 0;
        
        while (i <= doc.length() - word.length()) {
            if (doc.substring(i, i + word.length()).equals(word)) {
                count++;
                i += word.length();
            } else {
                i++;
            }
        }
        
        System.out.println(count);
    }
}
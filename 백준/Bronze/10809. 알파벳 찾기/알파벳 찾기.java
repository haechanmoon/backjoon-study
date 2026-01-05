import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        boolean[] flag = new boolean[26];
        Arrays.fill(arr, -1);
        String input = br.readLine();
        for(int i = 0 ; i<input.length();i++){
            char a = input.charAt(i);
            int b = a-'a';
            if(flag[b]){
                continue;
            }
            arr[b] = i;
            flag[b] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);
    }
}

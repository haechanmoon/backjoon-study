import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int left = 0;
        int right = 0;
        int kind = 0;
        int maxLen = 0;

        for(right = 0; right < N; right++) {
            if(count[fruits[right]] == 0) {
                kind++;
            }
            count[fruits[right]]++;

            while(kind > 2) {
                count[fruits[left]]--;
                if(count[fruits[left]] == 0) {
                    kind--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
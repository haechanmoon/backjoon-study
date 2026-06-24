import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001];
        double sum = 0;

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            sum += value;
            count[value + 4000]++;
        }

        System.out.println(Math.round(sum / N));

        Arrays.sort(arr);
        System.out.println(arr[N / 2]);

        int max = 0;
        for(int i = 0; i < 8001; i++) {
            if(count[i] > max) {
                max = count[i];
            }
        }

        int mode = 10000;
        boolean flag = false;

        for(int i = 0; i < 8001; i++) {
            if(count[i] == max) {
                if(flag) {
                    mode = i - 4000;
                    break;
                }
                mode = i - 4000;
                flag = true;
            }
        }
        System.out.println(mode);

        System.out.println(arr[N - 1] - arr[0]);
    }
}
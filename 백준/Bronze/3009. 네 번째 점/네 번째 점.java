import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int resX, resY;

        if (x[0] == x[1]) resX = x[2];
        else if (x[0] == x[2]) resX = x[1];
        else resX = x[0];

        if (y[0] == y[1]) resY = y[2];
        else if (y[0] == y[2]) resY = y[1];
        else resY = y[0];

        System.out.println(resX + " " + resY);
    }
}
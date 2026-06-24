import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> colors = Arrays.asList(
                "black", "brown", "red", "orange", "yellow",
                "green", "blue", "violet", "grey", "white"
        );

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        long value = (colors.indexOf(color1) * 10) + colors.indexOf(color2);

        long multiplier = (long) Math.pow(10, colors.indexOf(color3));

        System.out.println(value * multiplier);
    }
}

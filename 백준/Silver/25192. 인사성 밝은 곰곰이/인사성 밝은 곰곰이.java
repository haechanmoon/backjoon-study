import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> strings = new HashSet<>();

        for(int i = 0; i <N;i++){
            String s = br.readLine();
            if(!Objects.equals(s, "ENTER")){
                strings.add(s);
            }else {
                count += strings.size();
                strings.clear();
            }
        }
        count += strings.size();
        System.out.print(count);
    }
}

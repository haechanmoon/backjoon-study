import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String actor = br.readLine();
        String doctor = br.readLine();

        if(actor.length()>=doctor.length()){
            System.out.println("go");
        }else{
            System.out.println("no");
        }
    }

}

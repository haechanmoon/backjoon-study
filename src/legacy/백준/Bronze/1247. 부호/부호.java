
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0 ; i<3;i++){
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for(int j =0 ;j<N;j++){
                BigInteger next=new BigInteger(br.readLine());
                sum = sum.add(next);
            }
            int result = sum.compareTo(BigInteger.ZERO);
            if(result>0){
                System.out.println("+");
            } else if (result==0) {
                System.out.println("0");
            } else {
                System.out.println("-");
            }

        }
    }

}

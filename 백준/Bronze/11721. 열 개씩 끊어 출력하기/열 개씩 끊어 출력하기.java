import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<input.length();i+=10){
            if(i+10>input.length()){
                sb.append(input,i,i+input.length()%10);
                break;
            }
            sb.append(input, i, i+10).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<n;i++){
            String current = br.readLine();
            int sub = 0;
            int count =0;
            for(int j =0 ; j<current.length();j++){
                if(current.charAt(j)=='O'){
                    sub++;
                    count += sub;
                }else{
                    sub =0;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

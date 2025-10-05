package Solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class n_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int S = 0; //집합 역할을 할 정수 변수

        for (int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "all": {
                    S = (1 << 21) - 1;
                    break;
                }
                case "empty" : {
                    S = 0;
                    break;
                }
                case "add" : {
                    int x = Integer.parseInt(st.nextToken());
                    S |= (1 << x);
                    break;
                }
                case "remove":{
                    int x = Integer.parseInt(st.nextToken());
                    S &= ~(1<<x);
                    break;
                }
                case "check":{
                    int x = Integer.parseInt(st.nextToken());
                    if ((S & (1 <<x)) != 0){
                        sb.append(1).append("\n");
                    } else{
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "toggle":{
                    int x = Integer.parseInt(st.nextToken());
                    S ^= (1 << x);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

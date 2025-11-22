/*
증가하는거 찾는건데. 이거 max값이랑비교하면서 count올라가면서 하면 되는거 아닌가? 흠...
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;

        for(int i=0;i<N;i++){
            dp[i] =1;
            for(int j =0;j<i;j++){
                if(A[j]<A[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        
        System.out.print(maxLen);
        
    }
}

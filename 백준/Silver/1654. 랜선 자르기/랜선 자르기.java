/*
이거 내가볼 땐 greedy같은데...암만봐도.
일단. 이거 어떻게 푸냐면. 1부터 자르면 너무 오래걸리니까
젤 작은거를 기준으로 잘라봐. 그리고 개수를 구해. 거기서부터 1씩 늘려감녀서 최초로 같아지는 지점을 찾으면 그게 정답이지
일단 값들 받아보자..
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] cables = new long[K];
        long maxCableLength = 0;
        for(int i = 0; i<K;i++){
            cables[i] = Long.parseLong(br.readLine());
            if(cables[i] >  maxCableLength){
                maxCableLength = cables[i];
            }
        }

        long start = 1;
        long end = maxCableLength;
        long result = 0;

        while(start<=end){
            long mid = (start+end)/2;
            long count = 0;

            for (long cable : cables) {
                count += (cable/mid);
            }

            if(count>= N){
                result = mid;
                start = mid+1;
            }else {
                end = mid-1;
            }

        }

        System.out.println(result);

    }
}

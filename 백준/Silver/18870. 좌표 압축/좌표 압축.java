/*
이거는 뭘 위한 문제인지 잘 모르겠다.
1. 입력
    - BufferedReader 로 몇개인지 첫째줄 입력받기
    - BufferedReader , StringTokenizer로 분리
2. 처리
    - original[] 만들어서 원본 저장
    - copy[] 만들어서 사본 저장
    - HashMap<Integer,Integer> list에 저장 (중복일때 역시 HashMap을 쓰는거였어)
    - int rank 생성
    - copy를 HashMap에 넣을 때 값이 다를 때만 put(현재값, rank++)
    - origin 순회 하며 HashMap과 매칭
    - StringBuilder에 입력
3. 출력
    - StringBuilder 출력
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        for(int i = 0; i<N; i++){
            int T = Integer.parseInt(st.nextToken());
            origin[i] = sorted[i] =  T;
        }

        Arrays.sort(sorted);
        HashMap<Integer,Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i : sorted){
            if(!rankMap.containsKey(i)) {
                rankMap.put(i, rank++);
            }
        }
        for (int j = 0;j<N;j++){
            origin[j] = rankMap.get(origin[j]);
            sb.append(origin[j]).append(" ");
        }
        System.out.print(sb);
    }
}

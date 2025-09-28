package Solved_ac.class2;

//이 문제 뭔가 배열에서 얻어오는건가? 2000만 배열중에서 몇번쨰. 이렇게 하는건가?
//아니면 hashset 또 쓰는건가? hashset써서. 그렇게하는건가?
//하하 hashmap이라는거를 쓰는거구나. map.put / map.get 이거를 쓰는거구나 . 한번 짜볼까?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class n_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num =  Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else  {
                map.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st =  new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num2 =  Integer.parseInt(st.nextToken());
            if (map.containsKey(num2)) {
                sb.append(map.get(num2)).append(" ");
            }else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

    }
}

/*
자. 이건 첫째줄에 케이스가 몇개인지.
각 케이스마다 첫째줄에 몇벌의 의상이 있는지.
--> 종류마다 입을 수 있고 조합을 이룰 수있음.
중복이 들어가기 때문에 HashSet은 무조건 들어갈 거 같고.
아. 이건 뭘 써야하는지 감이 잘 안오네. List<List<string>>형태인가. 여기다가 HashSet걸어서? 하는건가? 몇개인지.
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int M = Integer.parseInt(br.readLine()); // 3. 이 케이스의 의상 수
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken(); 
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int answer = 1;
            for (int count : map.values()) {
                answer *= (count + 1);
            }
            sb.append(answer - 1).append('\n');
        }
        System.out.print(sb);
    }
}
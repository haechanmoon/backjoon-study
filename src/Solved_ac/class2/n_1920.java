package Solved_ac.class2;

import java.io.*;
import java.util.*;
/*
* 배운거 정리
* 일단. 레전드. 토크나이저. 일회성 티켓같은거. 쓰는법 좀 더 익혀야하듯.
* 그리고 스트링빌더 쓰는거 이제 완전히 알았다. ArrayList에는 add를 쓰는데 StringBuilder에는 .append이렇게 쓰는구나. 아하!
*
 */


public class n_1920 {
    //scanner냐 Arraylist냐. 근데 10만개면 ArrayList가 맞는거같다. ㅇㅈ?bufferdreader, stringbuilder도 같이 쓰는게 맞는것같다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken())))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}


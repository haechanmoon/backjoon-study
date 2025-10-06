package Solved_ac.class3;

/*이 문제는 일단 이름을 bufferedReader로 N줄, M줄 받은다음에
* Collection에 HashMap으로 당겨받아서
* 중복되는거 찾아서 마무리하는 것 같은데? 일단 그게 맞지 않나?
* compare A to B 도 있던것 같은데...그거는 맞는진 모르겠다..
* 하도 안한지 오래돼서 ㅎㅎ..
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class n_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set1 = new HashSet<>();
        for (int i =0; i<N;i++){
            set1.add(br.readLine());
        }

        ArrayList<String> set2 = new ArrayList<>();
        for (int i = 0; i<M;i++){
            String name = br.readLine();
            if(set1.contains(name)){
                set2.add(name);
            }
        }

        Collections.sort(set2);

        StringBuilder sb = new StringBuilder();
        sb.append(set2.size()).append('\n');
        for (String name : set2) {
            sb.append(name).append('\n');
        }
        System.out.println(sb);





    }
}

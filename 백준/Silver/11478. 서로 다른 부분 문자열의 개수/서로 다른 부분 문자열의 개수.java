/*
이거 substring이용해서 hashset에 넣어. 그리고나서 hashset의 개수를 구하는 그런거같은데? 서로달라야하니까말이야.
substring쓰는법은 만약 substring(3)이다? 그럼 4번째문자부터 끝까지를 자르는.
substring(2,4)? 그럼->. 3번째부터 4번째까지. 뭐 이렇게 잘라.
근데 이게 로직이 엄청 어렵진 않은것같긴한데.
abcdab뭐 이렇게 있으면
하나만 뽑을때는 처음에는 substring(i,i+0)뭐 이렇게 하는것같고.
두개뽑을때 substring(i,i+1) 뭐이런식.
---
string개수가 6이니까.
마지막 6개뽑을때는
substring(i,i+5)이렇게 하면 될듯?
상위 for문은 string.length()이고
하위 for문은 string.indexOf()이네.
이건 국룰인 bufferedReader안써도 될듯?
 */

import java.util.HashSet;
import java.util.Set;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<input.length();i++){
            for(int j = i+1; j<=input.length();j++){
                set.add(input.substring(i,j));
            }
        }
        System.out.print(set.size());
    }
}

/*
어떻게 하는게 좋을까?
자. 가보자.
한줄을 읽고 단어가 몇개인지를 맞춰야 하는프로그램이야.
stringTokenizer는 무조건 쓰는거같은데? 아 count도구가 있네 개꿀
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());
    }



}

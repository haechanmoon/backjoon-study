/*
세로읽기 . 이거 할 할 거 같은데?
금방 할 거 같은데? 뭐 어렵진 않을듯?
br로 받고. 뭐 charAt이거 짬뽕하면될거같은데. ? stringBuilder에다가 계속추가하고 ㅇㅇ
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        for(int i =0 ; i<5;i++) {
            list.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<15;i++){
            for(String val : list){
                if(val.length()-1<i){
                    continue;
                }
                sb.append(val.charAt(i));
            }
        }
        System.out.println(sb);
    }
//commit
}

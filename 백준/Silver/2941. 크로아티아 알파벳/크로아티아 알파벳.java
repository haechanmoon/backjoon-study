/*
흠 . 이건 또 신기한문제네. 근데 이런게 진짜 실무에 도움이 되는 문제가 아닐까!한다.
ArrayList<String>에다가 넣어야하나? 그래서 거기에 c= c- dz= d- lj nj s= z= 이 문자들이 있는지 봐야해.
음. 뭐부터 진짜 해야하지. mapping기능 써야하나? 그래서 그 문자는 1개로치고. 음.
아! string .replace()!
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] target = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(String val:target){
            input = input.replace(val,"a");
        }
        System.out.print(input.length());
    }
}

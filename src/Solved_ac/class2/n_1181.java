package Solved_ac.class2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;


public class n_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();

        HashSet<String> wordSet = new HashSet<>();
        for(int i = 0; i < N; i++){
            wordSet.add(sc.next());
        } //중복없이 단어들을 받아줌. 근데 배열을 안써도 되는건가? 이거 물어봐야겠다.
        String[] words = wordSet.toArray(new String[0]); //to Array()안에는 뭐가 들어가는걸까?
        //Comparator<string>() 여기서 소괄호()안에는 뭐가 들어가는지?
//왜 Override 쓰는지?
        Arrays.sort(words, (o1, o2) -> { //모르는거 알아보자. 이거는 꼭 알아야해. compare함수란 무엇인지?
            if(o1.length() == o2.length()){ //이거 for문이 없는데 어떻게 지정을 하는건지?어떻게 다음으로 넘어가는건지?
                return o1.compareTo(o2);
            }else{
                return o1.length() - o2.length(); //이게 음수가 나올수도 있는데 왜 이런식이 나온건지.
            }

        });

        for(String word : words){
            System.out.println(word);
        }
    }
}

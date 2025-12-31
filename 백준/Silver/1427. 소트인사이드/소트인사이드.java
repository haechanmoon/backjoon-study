/*
이거 뭐 할만할것같은데? 그냥 collection에 때려박아서 뭐 만들면그만아닌가? 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0 ; i<input.length();i++){
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);
        StringBuilder sb = new StringBuilder();
        for(int val : numbers){
            sb.append(val);
        }
        System.out.println(sb);
    }
}

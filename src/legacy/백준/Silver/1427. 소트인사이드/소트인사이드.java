
/*
이거 뭐 할만할것같은데? 그냥 collection에 때려박아서 뭐 만들면그만아닌가?
 */

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class n_1427 {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        List<Integer> numbers = new ArrayList<>();
//        for(int i = 0 ; i<input.length();i++){
//            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
//        }
//        Collections.sort(numbers);
//        Collections.reverse(numbers);
//        StringBuilder sb = new StringBuilder();
//        for(int val : numbers){
//            sb.append(val);
//        }
//        System.out.println(sb);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length()];
        for(int i = 0 ; i<input.length();i++){
            arr[i] = input.charAt(i)-'0';
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1 ;i>=0;i--){
            sb.append(arr[i]);
        }
        System.out.print(sb);
    }
}

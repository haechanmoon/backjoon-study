package Solved_ac.class2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class n_1181_new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(sc.next());
        }
        String[] T = set.toArray(new String[0]);
        Arrays.sort(T, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else {
                return o1.length() - o2.length();
            }
        });
        for (String s : T) {
            System.out.println(s);
        }

    }
}

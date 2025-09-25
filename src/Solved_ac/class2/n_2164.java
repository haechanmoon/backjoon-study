package Solved_ac.class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n_2164 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N =  input.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        while(q.size() > 1){
            q.poll();
            int x = q.poll();
            q.add(x);
        }
        System.out.println(q.poll());
    }
}
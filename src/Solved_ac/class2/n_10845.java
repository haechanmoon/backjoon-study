package Solved_ac.class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int last = -1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String S = sc.next();


            //System.out.println(-1);
            switch(S) {
                case "push":
                    int num = Integer.parseInt(sc.next());
                    q.add(num);
                    last = num;

                    break;
                case "pop":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(q.peek()).append("\n");

                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

package woowacote.d_0522;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n_2164 {

    // 1. 일단 N개 받아와서 큐에 다 박아넣어야함. 이거는 for로 구현해도 될듯?
    // 2. while(큐가 하나 남을 때 까지)
    // 3. poll()하고 poll()과 add() 이 사이클을 반복한다.
    // 4. 이렇게 하는게 맞나? 맞나요?

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1 ; i<=n;i++){
            que.add(i);
        }
        while (que.size()>1){
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.peek());
    }
}

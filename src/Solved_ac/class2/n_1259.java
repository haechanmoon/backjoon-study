package Solved_ac.class2;

import java.util.Scanner;

public class n_1259 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
        /*이거는 솔직히 쉬운데. 근데 여러개 받아서 한번에 처리하는게 아니라 바로바로 결과나와도 솔직히 상관없는거아닌가?
        그때도 그랬던것같은데. 그렇게하자.
        이거 어제 했잖아. 배열만들어서 숫자넣기.
        일단 짝수자리수들은 거르고.
        배열 T 만들어서 각 자리 숫자 넣어. 번호매겨.
        N자리수라고하면
        T[0] 이랑 T[N-1] 맞아야하고 T[1] T[N-2]맞아야하고..
        이거를 i에다가 넣고 돌려야겠네? 어디까지?
        만약 7자리수면 가운데가 어디야 4 N/2+1까지네. ㅇㅋ
        그래서 참이면 yes 출력 아니면 no 출력. 이렇게 하면 될듯.
         if홀수이면

         */
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int T = N;
            int P;
            int count = 0;
            while (T != 0) {
                count++;
                T /= 10;
            } // 여기는 자릿수 구하기. count는 자리수임.
            T = N;
            int copycount;
            copycount = count;
            int[] A = new int[count];
            boolean flag = true;
            while (count != 0) {
                P = T % 10;
                T /= 10;
                A[count - 1] = P;
                count--;
            }
            for (int i = 0; i < copycount / 2; i++) {
                if (A[i] != A[copycount - 1 - i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
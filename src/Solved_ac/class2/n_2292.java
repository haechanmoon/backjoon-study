package Solved_ac.class2;

import java.util.Scanner;

public class n_2292 {
    public static void main(String[] args) {
        /*구간을 나눠야될거같은데? 1, 2~7(6개), 8~19(12개), 20~37(18개), 38~61(24개), 62~91(30개)
        * 이런식이구나. 그럼 어떻게 해야할까...1은 냅두고, 6씩 증가하는 변수를 하나 놔야될거같은데
        * T<=N<K, 다음꺼에서 T는 K가 되고, K는 6씩 증가하는 수가 더해지는거겠네. 그걸 P라고 둘까? P는 6씩 더해지는거야.
        * K<=N<K+P
        * while 거기에 들어올때가지.다되면 break;
        * total ++ 해주는거야!
        * 그럼 정했어.
        * 예시코드작성
        *
        int total = 0;
        if(N==1){
            total =1;
        }else if(2<=N&&N<=7){
            total =2;
        }else if(8<=N&&N<=19){
            total =3;
        }else if(20<=N&&N<=37){
            total =4;
        }else if(38<=N&&N<=61){
            total =5;
        }
        else{
            total =6;
        }
        System.out.println(total);

    }
        * */
        //근데 이렇게 푸는게 맞나? 이건 너무쉬운데
        //뭔가 공식을 더 썼어야 하는게 아닌가

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //입력 받기 완료! 자 이제 뭐부터 해야하나.
        //함수를 하나 만들어야겠는걸?
        int T=1; int K =2; int P=0;
        int total =1;
        while (true) {
            if(T<=N&&N<K){
                System.out.println(total);
                break;
            } else if (N>=K) { // ******여기 수정함~~~****
                P += 6;
                K += P;
                total++;
            }
        }
    }
}

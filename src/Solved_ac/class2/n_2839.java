package Solved_ac.class2;

/*
일단 이 문제는 안되는거부터 거르는게 맞는거같은데.
어떻게 거를것이냐..
4안되고 7안되고 생각하는과정... 일단 5로 나눠보고 나머지가 생겨서 3으로 나눠지면 OK 인데 안나눠지면 out이잖아.
이걸 식으로 해보면 (A%5)%3==0 이 되어야하네? 근데 이거 함정이 11같은거 나올때. 아 나머지가아니라 빼기가 좋을듯?
1. (A-5*i)%3==0 가능? 여기서 i는 5의 개수가 되겠네. 이거 안되면 탈락. 반대로하면? 반대로 해도 똑같긴하다.
꼭 반대로만 해야하는경우가 있나? 논리적으로 허점이 없다. 이게 맞는것ㅌ다. 어짜피 5로 나누는 과정이기도 하니까. 이걸로 밀자.
자. 그럼 어떻게 해야할까.
2. 가능하다면 i가 제일 클수록 좋겠지? 가능한것중 i가 큰 경우를 골라서. (N-5*i)/3하면 이제 답이 되겠네.
 */

import java.util.Scanner;


public class n_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = (N / 5); i >= 0; i--) {
            if ((N - (5 * i)) % 3 == 0) {
                System.out.print(i+((N - (5 * i)) / 3));
                break;
            }else if(i==0 && N%3!=0){
                System.out.print(-1);
            }

        }

    }
}

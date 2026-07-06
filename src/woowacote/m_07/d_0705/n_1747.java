package woowacote.m_07.d_0705;

/*
N보다 크고 소수이면서 팰린드롬수를 찾는. 최소값을 찾는 과정입니다.
일단 이거는 흠. N이 100만이기 때문에 시간복잡도를 잘 생각을 해야할 것 같습니다.
이거는 어떻게 푸는게 좋을까?
일단. 100만까지의 소수들을 모두 구해내는게 좋겠다 라는 생각을 했습니다. 그 이후 새로운 배열을 만들고
그 배열에서 펠린드롬수를 구하는게 좋다. 그리고 그거를 Integer를 String으로 변환하면 딱 될 것 같은데?

일단 100만까지의 소수들을 구한다.
그것을 배열에 옮긴다.
N 이상부터 펠린드롬 수인지 검사한다.
펠린드롬 수는 형 변환을 통해 구한다.
할 수 있을 것 같은데?
 */

import java.util.Scanner;

public class n_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int MAX = 1_005_000;
        int limit = (int) Math.sqrt(MAX);
        boolean[] arr = new boolean[MAX];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= limit; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    arr[j] = true;
                }
            }
        }
        for (int i = N; i < MAX; i++) {
            if (!arr[i]) {
                String a = String.valueOf(i);
                if (palen(a)) {
                    System.out.println(a);
                    break;
                }
            }
        }
    }

    private static boolean palen(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            if (!(value.charAt(i) == value.charAt(value.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}

/*
이거 생각해야할 게 한두가지가 아니네.
1. 일단 단어들을 추출해서 각각 몇개씩있는지 알아봐야해.
2. 단어들 중 홀수인 단어가 1개면 괜찮은데 2개면 만들 수 없음.
3. 짝수들인 단어를 그럼 어떻게 나타내야하나?
4. 일단 중앙으로 나눠서. 하나가 맨 왼쪽이면 그 다음은 맨오른쪽 이런식으로나타내야겠지?
5. 그리고 홀수인 단어는 무조건 가운데 박아넣어야해. length()/2+1 여기고정임.
6. char[]을 나타내야하나? 진짜 빠르게 한번 만들어보자.
7. 시간이 없으니 함수쪼개기 말고 그냥 빠르게 ㅇㅇ 함 달려보자!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alpha = new int[26];
        for(int i = 0; i < input.length(); i++) {
            alpha[input.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        char mid = 0;
        for(int i = 0; i < 26; i++) {
            if(alpha[i] % 2 != 0) {
                oddCount++;
                mid = (char)(i + 'A');
            }
        }

        if(oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        String result = sb.toString();
        if(mid != 0) {
            result += mid;
        }
        result += sb.reverse().toString();

        System.out.println(result);
    }
}
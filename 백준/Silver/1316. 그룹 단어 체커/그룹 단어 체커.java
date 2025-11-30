/*
2025/11/30 1일차
단어의 조합을 보는 프로그램.
이거 함수를 좀 쪼개면 좋을것같은데? 한번에 물론 쭉 짜도 좋지만.ㅎ
일단 함수를 하나 만들어야함.
검사하는 로직 하나 만들면좋을것같고.
뭐 어렵지 않을것같음! 배열에다가 저런것들 넣고 이리저리 돌려가면서 ~

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean check() throws IOException {
        boolean[] visited = new boolean[26];
        String st = br.readLine();
        int prev = 0;

        for (int i = 0; i < st.length(); i++) {
            int now = st.charAt(i);

            if (prev != now) {
                if (visited[now - 'a']) {
                    return false;
                }
                visited[now - 'a'] = true;
                prev = now;
            }
        }
        return true;
    }
}
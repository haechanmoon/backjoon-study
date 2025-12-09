/*
흠. 문자열비교네. 이거 함수를 많이 만들어야하나.
compare함수 있었는데 솔직히 그거 안쓴지 너무오래됨.
흠. . .
일단.
1. 길이비교. 짧은게 먼저옴.
2. 만약 길이같으면 A의 숫자 B의 숫자 비교 작은게 먼저
3. 사전순 비교.
이건 함수 3개 만들어서 이리저리 굴리면 되는거아님?
한번해볼까?
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }

                int sum1 = getSum(s1);
                int sum2 = getSum(s2);

                if (sum1 != sum2) {
                    return sum1 - sum2;
                }

                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : serials) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    public static int getSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum += (c - '0');
            }
        }
        return sum;
    }
}
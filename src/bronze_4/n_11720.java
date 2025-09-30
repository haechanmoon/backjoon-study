package bronze_4;

import java.util.Scanner;

public class n_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String numbers = sc.next(); // "54321" 과 같은 숫자 덩어리를 문자열로 받음

        int sum = 0;
        // 문자열의 길이만큼 (N번) 반복
        for (int i = 0; i < N; i++) {
            // charAt(i)로 i번째 글자를 가져온 뒤, '0'을 빼서 숫자로 변환
            sum += numbers.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
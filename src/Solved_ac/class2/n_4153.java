package Solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class n_4153 {
    public static void main(String[] args) throws IOException {

        // 입력을 빠르게 받기 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 무한 루프 시작
        while(true) {
            // 1. StringTokenizer로 한 줄을 읽어와. (공백 기준으로 쪼개줘)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 2. 세 숫자를 각각 변수에 저장해.
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 3. 만약 0 0 0 이 입력되면? -> "탈출!"
            if (a == 0 && b == 0 && c == 0) {
                break; // while 루프를 끝내.
            }

            // 4. 여기서부터 네가 아는 로직을 쓰면 돼!
            //    - 세 숫자를 1차원 배열에 딱 넣고,
            int[] sides = {a, b, c};
            //    - 바로 정렬하고,
            Arrays.sort(sides); // 이렇게 하면 sides[2]가 항상 가장 긴 변(빗변)이 됨

            //    - 피타고라스 정리로 확인하고 결과를 출력해.
            if ((sides[0] * sides[0]) + (sides[1] * sides[1]) == (sides[2] * sides[2])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
package Solved_ac.class2;
/*
        문제 : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
        자. 어떻게 풀어야할까..보자.
        소인수분해를 했어야 하지 않았나?
        12랑 18이 있어. 12 = 2^2*3 18=2*3^2 여기서 겹치는거 2*3이라 6 이거아녔나?
        최소공배수는36인데 이게 어떻게 나왔지 2^2*3^2 이거였나...그럼 어떻게 해야하지.
        36과 42 36 = 2^2*3^2 / 42 = 2*3*7 이거잖아.
        최대공약수 = 6 최소공배수 = 6*6*7 = 252
        이게 맞는것같다. 이걸 어떻게 하지?
        아 깨달았다.
        2부터 숫자/2 까지 for문돌려서 나눠지면 그거 배열에 넣어. 그리고 나눠진걸로 2부터 또 다시해. 그렇게 집어넣어.
        그리고 비교해. 2 2 3 5   2 3 3 5 이렇게있으면 그냥 그렇게 하지말고.이렇게 하자.
        일단.
         */

import java.util.Scanner;

public class n_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int copyN = N;
        int copyM = M;

        int a = 0;               // 공약수 저장 개수
        int multiple = 1;        // 최대공약수
        int[] same = new int[100];

        // 공약수(소인수) 찾기
        for (int i = 2; i <= N && i <= M; i++) {
            while (N % i == 0 && M % i == 0) {
                N = N / i;
                M = M / i;
                same[a] = i;  // 공약수 저장
                a++;
            }
        }

        // 최대공약수 구하기
        for (int j = 0; j < a; j++) {
            multiple *= same[j];
        }

        // 공약수 없으면 최대공약수는 1

        System.out.println(multiple);

        // 최소공배수 구하기 (공식: copyN * copyM / gcd)
        int total = copyN * copyM / multiple;
        System.out.println(total);
    }
}

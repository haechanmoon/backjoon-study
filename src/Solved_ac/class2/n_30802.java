package Solved_ac.class2;

import java.util.Scanner;

public class n_30802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = sc.nextInt();
        }
        int T = sc.nextInt();
        int P = sc.nextInt(); //여기까지 입력은 다 받았어!

        //이제부터는 알고리즘
        // 티셔츠 묶음 계산
        int t_bundles = 0;
        for (int sizeCount : sizes){
            t_bundles += sizeCount / T;
            if(sizeCount % T != 0){
                t_bundles++;
            }
        }

        //펜 묶음 계산
        int p_bundles = N / P;
        int p_remain = N%P;

        //출력
        System.out.println(t_bundles);
        System.out.println(p_bundles+ " " + p_remain);





        /*자. 일단. 어떻게 풀어야할까?
        입력받아야될게 뭐가있지?
        N 총개수
        근데 사이즈별로 다 입력받는건가? 그리고 공백이랑 다음칸에 쓰는거랑
        별 차이없는거같은데 그냥 써야되나?
        그리고 T를 기준으로 잡아야 하는데 만약 T보다 큰 수가 존재한다?
        그럼 그것만 빼서 해야지
        그럼 그거 횟수를 출력하는거야. 그리고 연필 하. 연필은무ㅇ냐도대체.
        이거 근데 내가 코드를 짤 순 있긴 한가? 도저희 알고리즘을 모르겠네.

         */

    }
}

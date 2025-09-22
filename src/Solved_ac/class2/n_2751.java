/*package Solved_ac.class2;

import java.util.Scanner;
import java.util.Arrays;

public class n_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //이거 정렬하는거는 많이 배우지 않았나? 근데 이건 sort쓰면 그냥 될거같긴한데..?
        int[] Arr = new int[N];
        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }
        Arrays.sort(Arr);
        for (int i = 0; i < N; i++) {
        System.out.println(Arr[i]);
        }

    }
}

틀린이유 분석

시간초과. 솔직히 이거 시간제한없었으면 걍 풀긴했어. 솔직히 브3정도 문제 ㅋㅋ개쉽잖아 솔직히이정도는.
근데 stringBuffer이건 도저히 뭔지 잘 모르겠다. 어디서부터 알아야할까.
Array.sort() 저격한 문제라는데 그것도 맞긴한듯. 앞으로는 Collections.sort()쓰래.
그리고 입출력 문제가 있는데 Scanner와 System.out.print이게 엄청 오래걸리나봐.
그래서 이문제는 2가지가 있네. Array.sort-> Collections.sort || Scanner --> BufferReader
그럼 코드를 한번 따라해보자!

*/
/*
package Solved_ac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.in -->재료공급원
        InputStreamReader -->


        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        for (int value : list) {
            sb.append(value).append("\n");
        }

        System.out.print(sb);


    }
}
*/
/*
* 혼자힘으로 다시 해보기.
* 화이팅! 할수있다.
 */

package Solved_ac.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class n_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        for (int value : list) {
            sb.append(value).append("\n");
        }
        System.out.print(sb);
    }
}



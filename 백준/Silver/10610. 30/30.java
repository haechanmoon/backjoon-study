/*
간만에 찾아온 실버문제.
일단. 숫자에 0이 무조건있어야함. 그리고 3의 배수 특성상
다 더해서 3의 배수가 되어야함.
그리고 가장 큰 값을 배출해야하기 때문에
어떻게든 큰 수부터 나열하면됨. 솔직히 막 그렇게 어려운 문제는 아닌듯.
자 !!가보자
일단. 모든 숫자를 읽어들여서
배열에 넣는게 제일 낫겠다.
 1. 근데 일단 0이 있어야함.
음. 그래 배열에 넣자.
그 다음에는 배열에 있는 모든 수 다 더해.
2. 다 더한게 그게 3으로 나눠떨어지는지 봐야함.
만약 나눠 떨어지면 ? ㅇㅋ 다음단계
3. 큰 수부터 나열함. sort하면 되지 않나? Arrays.sort그냥 하면 될것같은데. 안되나. 일단 한번 해보지 뭐.
그리고 그거 그냥 sb에 출력하면되는거아닌가 별거없긴하네.
입력하나밖에 없으니까 그냥 scanner 쑤자.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        List<Integer> numList = new ArrayList<Integer>();
        for(int i = 0 ; i<num.length();i++){
            numList.add(Integer.parseInt(num.substring(i,i+1)));
        }
        if(!numList.contains(0)){
            System.out.print(-1);
            return;
        }
        int sum = 0;
        for(Integer val : numList){
            sum += val;
        }
        if((sum%3)!=0){
            System.out.print(-1);
            return;
        }
        Collections.sort(numList);
        StringBuilder sb = new StringBuilder();
        Collections.reverse(numList);
        for(Integer val : numList){
            sb.append(val);
        }
        System.out.print(sb);
    }
}

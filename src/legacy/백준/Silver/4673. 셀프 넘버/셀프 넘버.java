/*
흠..이건 생각을 좀 해봐야겠군.
어떻게 어디서부터 해야할까
생성자가 없는 숫자를 고르라...이거 참 난감하군.
1,3,5,7,9,20,31,...등등 이게 셀프넘버라고 하는데. 이거를 어떻게 고르지?
생성자가 있는지 없는지를 알아야하는건가?
예를들어 13이야. 13 (11) -> 11+1+1흠. 이거 있네.
그니까. 이거를 어떻게 알지
내가봤을 때 이거 직접 구하는거보다 아닌거를 빼는게 더 맞는것같다. 수학문제푸는게 아니니.
1부터 쭉 계산해. 1+1 2+2 3+3 ---> 이렇게 갈거아녀. 그럼 10 -> 11 11-> 13 12-> 15
이거를 List에 다 넣는거야
그리고 1부터 10000까지 포함 안되어 있는거를 빼는거야! 오케이?
그렇게 한 번 풀어보자.

1. 1부터 시작.10000까지. 계속 변하는 변수 하나. num
2. 그리고 이걸 어떻게 하냐면. boolean[10001] check을 만들어.
3. 그리고 값이 딱 나오면 그 변수를 true로 만들어.
4. 그리고 check[]에서 false인거의 위치를 출력해. 한줄에 하나씩.
5.
 */

public class Main {
    private static final int MAX = 10000;
    private static final int START = 1;

    public static void main(String[] args){
        boolean[] checkNum = new boolean[MAX+1];
        for(int i =START;i<=MAX;i++){
            //함수를 두 번호출하지 말고 변수에 하나 담아서 한번만 호출할 수 있게!
            int generatedNum  = totalUnit(i);
            if(generatedNum>MAX){
                continue;
            }
            checkNum[generatedNum] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = START;i<=MAX;i++){
            if(!checkNum[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int totalUnit(int N){
        int temp = N;
        while (N>0){
            temp += N%10;
            N/=10;
        }
        return temp;
    }
}

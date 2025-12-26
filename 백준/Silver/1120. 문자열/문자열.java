/*
아주 재밌는 문제구만.
일단. 첫번쨰 나오는거는 일단 작거나 같다 이거지?
이제 그 차이를 구하라 이거지?
OK 그럼 . 어떻게 해야할까나
이 앞 문자 있잖아.
이거를 다음 문자에 parsing을 해보고
거기에 몇개 있는지 맞추면 솔직히 끝아니냐?
뭐 엄청 어려운 문제는 아닌것같은데
그니까 3개짜리를 슬라이딩하면서
제일 많이맞는곳에 갖다둔다음에 나머지는
뭐 다 갖다 붙힐 수 있으니까.
A가 B에 얼마나 맞느냐 이걸 구하는건데.
최소값을 갱신하는게 필요하겠구만.
음. 어떻게 하는게 제일 좋은 판단일까나
일단. 내가봤을 땐말이야.
substring을 쓰는건가? 근데 여기서는 substring잘안쓰던데.
시간복잡도 높은거때문에.
그럼 뭘쓰는걸까 이중for문 쓰면 금방 구하긴함.
차이를 출력하는거니까 min을 보내면 되긴 하겠다. 솔직히 뭐 별거없는...
한번 해볼까요
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String inputOne = st.nextToken();
        String inputTwo = st.nextToken();

        int diff = inputTwo.length()-inputOne.length();
        int min = inputOne.length();

        for(int i = 0 ; i<=diff;i++){
           int diffCount = 0;
            for(int j = 0; j<inputOne.length();j++){
                if(inputOne.charAt(j)!=inputTwo.charAt(i+j)){
                    diffCount++;
                }
            }
            min = Math.min(diffCount, min);
        }

        System.out.print(min);
    }
}
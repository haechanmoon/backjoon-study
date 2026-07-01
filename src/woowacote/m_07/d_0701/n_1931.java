package woowacote.m_07.d_0701;

/*
회의실 배정하기

흠. 이거는 어떻게 푸는게 좋을까말이야. 음. 일단 회의시간이 짧은걸 배정하는게 가장 좋겠죠? 배정을 잘 하는게 좋을것같은데?
일단 그럼 회의시간이 짧은거를 정렬하고 거기서 이제 낮은것부터 가져가는거지. 이렇게 하는게 아닌가? 일단 해볼까?
그런 다음에 끝나는거 이상으로 가져오는게 일단 맞는거 같은데 어떻게 생각하나? 아 이거 좀 어려운데? 이거를 그리디로..?
해 구하기
구현하기
해 검증하기

일단. 내 아이디어. 배열을 하나 두고 시작부터 끝-1까지 true로 채우는거야. 그 다음에 true면 올 수 있게 채우는거지
그리고 count를 계속 ++ 때려. 이렇게 하면 되지 않을까나? 한번 해보자.  아. 근데 엣지 케이스 있네. 시작과 끝이
같을 수 있으니까 이거는 그냥 true 로 넣지 말고  count만 ++하면 될듯? 근데 이게 아다리가 진짜 안맞을 수 있잖아.
흠. 새로운 자료구조를 써야하는건가? 아~~복잡하긴하네. 아. 아니면 이런것도 있겠다.
그니까 일단 나오는 모든 시간들을 다 일단 때려 박은다음에 잘 거르면 되지 않을까? 이거는 아이디어가 좀 필요한 것 같다.
아. 이거 종료시간을 기준으로 해야하네. 그니까 빨리 끝나는놈이 우선인거야. 그렇게 하고 for문 돌리면서 줍줍하면 이득!
와. 이런거 어떻게 생각했냐 출제자들아 ㅋㅋ 그래 공부 많이 된다~
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(br.in));
        int N = Integer.parseInt(br.readLine());

        // time[i][0]은 시작 시간, time[i][1]은 종료 시간
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬 기준 설정
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0; i < N; i++) {
            if (time[i][0] >= prevEndTime) {
                prevEndTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}

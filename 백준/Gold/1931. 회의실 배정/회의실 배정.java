/*
회의실...일단 차가 작은것부터 정렬
그리고 앞에꺼가 작은거부터 다시 정렬
그 다음엔. 맨 처음꺼 골라. 그다음에 뒤에서꺼부터 다시 선택. 그 다음에 또 선택. 또 선택. 해서 끝까지 가버리기!
그러면 어떻게 해야할까?
만약 1 3 / 2 4 / 3 5/ 뭐 이렇게 나올겅니야. 1 3 3 5 이렇게 가야겠지.
1. 차가 작은거 부터 불러오기.
2. 그 안에서 시작 시간이 작은거부터 정렬. 아마 for문안에 있을 거 같은데?
3. 끝나는시간부터 뒤에꺼 뭐 올지 고르기.
4. 끝.

그럼 필요한 함수. 1. 차가 작은거로 정렬
2. 오름차순으로 정렬
3. 끝나는 시간 뒤에꺼 뭐 올지 고르기 정렬
4. 끝.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int meetingNumber = Integer.parseInt(st.nextToken());
        Meeting[] meetings = new Meeting[meetingNumber];
        for (int i = 0; i < meetingNumber; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end==o2.end){
                    return o1.start-o2.start;
                }
                return o1.end - o2.end;
            }
        });
        int count = 0;
        int lastEndTime = 0;
        for(Meeting meet : meetings){
            if(meet.start>=lastEndTime){
                count++;
                lastEndTime = meet.end;
            }
        }

        System.out.println(count);
    }
}

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
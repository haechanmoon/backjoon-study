package Solved_ac.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class dots{
    int x;
    int y;
    public dots(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//스캐너 쓰는것보단 bufferedReader 쓰는게 좋겠지? 일단 N이 겁나 10만인데 ㅋㅋ ㅇㅈ?
//그리고 음 뭘써야하는거지. 일단 근데 Essential만 푸는것도 좋긴한데 다른문제들도 같이 풀어줘야겠네. 연습이 확실히 되긴 하겠다.
//StringBuilder를 같이 이렇게 섞어서 쓰면 되는건가? 일단 정렬은 Arraysort써서. 이렇게 하면될듯. 그리고 일단 정렬하고 그안에서
//X값같으면 y비교해주는걸로. 뭔느낌인지 알지? 아니면 compare그거 써야하나. 규칙만들어서. 그것도 하면하긴한데


public class n_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<dots> al = new ArrayList<dots>();
        for (int i = 0; i < N; i++){
            String[] xy = br.readLine().split(" ");
            al.add(new dots(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }
        Collections.sort(al, new Comparator<dots>() {
            @Override
            public int compare(dots o1, dots o2) {
                if(o1.x == o2.x){
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });
        for (dots d : al){
            sb.append(d.x).append(" ").append(d.y).append("\n");
        }
        System.out.print(sb);
    }
}

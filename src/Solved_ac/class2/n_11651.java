package Solved_ac.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class dots2{
    int x;
    int y;
    dots2(int x,int y){
        this.x=x;
        this.y=y;
    }
}


public class n_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<dots2> al = new ArrayList<dots2>();
        for (int i = 0; i < N; i++) {
            String[] xy =  br.readLine().split(" ");
            al.add(new dots2(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
        }
        Collections.sort(al, new Comparator<dots2>() {
            @Override
            public int compare(dots2 o1, dots2 o2) {
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }else{
                    return o1.y - o2.y;
                }
            }
        });
        for(dots2 d : al){
            sb.append(d.x).append(" ").append(d.y).append("\n");
        }
        System.out.print(sb);
    }
}

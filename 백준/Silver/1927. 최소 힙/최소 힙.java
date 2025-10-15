import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        int N = Integer.parseInt(br.readLine());
        for (int i= 0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(minHeap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                sb.append(minHeap.poll()).append("\n");
                }
            }else {
                minHeap.offer(x);
            }
        }
        System.out.print(sb);
    }
}

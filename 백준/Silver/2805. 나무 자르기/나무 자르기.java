import java.io.*;
import java.util.Arrays; // Arrays를 import 해야 합니다.
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int treeCount = Integer.parseInt(st.nextToken());
        int needHeight = Integer.parseInt(st.nextToken());
        int[] trees = new int[treeCount];

        st = new StringTokenizer(br.readLine(), " ");
        int maxTreeHeight = 0;
        for (int i = 0; i < treeCount; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxTreeHeight) {
                maxTreeHeight = trees[i]; // 이분 탐색의 end 범위를 위해 최대 높이를 찾아둠
            }
        }

        long start = 0;
        long end = maxTreeHeight;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2; // 현재 시도해볼 절단기 높이

            // --- 여기가 핵심! mid 높이로 잘랐을 때 얻는 나무의 총 길이를 계산 ---
            long sum = 0;
            for (int tree : trees) {
                if (tree > mid) { // 나무가 절단기보다 높아야 잘림
                    sum += (tree - mid);
                }
            }
            // --- 계산 끝 ---

            // 계산된 sum과 needHeight를 비교
            if (sum >= needHeight) {
                result = mid; // 일단 정답 후보로 저장
                start = mid + 1; // 더 높은 높이도 가능한지 탐색
            } else {
                end = mid - 1; // 나무가 부족하므로 높이를 낮춰야 함
            }
        }
        System.out.println(result);
    }
}
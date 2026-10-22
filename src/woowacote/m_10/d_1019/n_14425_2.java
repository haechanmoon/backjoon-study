package woowacote.m_10.d_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_14425_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for (int i = 0; i < N; i++) {
            insert(root, br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (contains(root, br.readLine())) {
                count++;
            }
        }
        System.out.print(count);
    }

    static void insert(Node root, String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // a는 0번, z는 25번
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isEnd = true; // 마지막 문자까지 이동한 뒤 단어의 끝을 표시
    }

    static boolean contains(Node root, String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEnd; // 경로가 있어도 저장된 단어의 끝이어야 함
    }

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }
}

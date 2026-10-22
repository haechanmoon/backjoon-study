package woowacote.m_10.d_1020;

/*
트리순회

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1991 {

    public static int N;
    public static int[] left;
    public static int[] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        left = new int[26];
        right = new int[26];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            left[parent] = leftChild == '.' ? -1 : leftChild - 'A';
            right[parent] = rightChild == '.' ? -1 : rightChild - 'A';
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        System.out.println();
    }

    public static void preorder(int node) {
        if (node == -1) {
            return;
        }

        System.out.print((char) (node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    public static void inorder(int node) {
        if (node == -1) {
            return;
        }

        inorder(left[node]);
        System.out.print((char) (node + 'A'));
        inorder(right[node]);
    }

    public static void postorder(int node) {
        if (node == -1) {
            return;
        }

        postorder(left[node]);
        postorder(right[node]);
        System.out.print((char) (node + 'A'));
    }
}

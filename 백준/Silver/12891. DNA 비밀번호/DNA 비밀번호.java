//package woowatest.woowateststudy;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class n_12891 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int length = Integer.parseInt(st.nextToken());
//        int subLength = Integer.parseInt(st.nextToken());
//
//        String input = br.readLine();
//
//        st = new StringTokenizer(br.readLine());
//        int[] validate = new int[4];
//        for(int i = 0 ; i<4;i++){
//            validate[i] =  Integer.parseInt(st.nextToken());
//        }
//
//
//
//        int count = 0;
//        boolean next = false;
//        //자 이제 입력받는건 다 끝났음.
//        //이거 근데 딱 보니까 substring으로 조지면 빨리 끝날것같은데? substring결과가 subLength만큼 차이가 나아햐나까.
//        //그리고 그 끝부분의 범위는 참이면 안되는거고 말이야.
//        //일단 그 식을 좀 세워볼까. for문으로 조지면 될것같은데.
//        //근데 이거 숫자로 장난질치면될것같은데. A나오면 ACGT int 배열만들어서 거기에 문자 나오면 인덱스 하나씩 올리는걸로.
//        //그리고 조건에 맞는 인덱스보다 다 크면 sub 인정. count++; 이렇게 하면 될 것 같다.
//        //아니 근데 만약 모든 배열이 다 충족하면 통과 이거를 어떻게 하는거야? 아놔 까먹었네. 이렇게 하는거. 안한지 너무 오래돼다보니까말이야.
//
//        for(int i = 0 ; i<length-subLength;i++){
//            String sub = input.substring(i,i+subLength);
//            int[] check = new int[4];
//            for(int j = 0 ; j<sub.length();j++){
//                if(sub.charAt(j)=='A'){
//                    check[0]++;
//                }else if(sub.charAt(j)=='C'){
//                    check[1]++;
//                }else if(sub.charAt(j)=='G'){
//                    check[2]++;
//                }else if(sub.charAt(j)=='T'){
//                    check[3]++;
//                }
//            }
//
//            for(int k = 0 ; k<4;k++){
//                next = check[k] >= validate[k];
//            }
//            if(next){
//                count++;
//            }
//        }
//        System.out.print(count);
//    }
//}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] myArr = new int[4];
    static int[] checkArr = new int[4];
    static int checkSecret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String A = br.readLine();
        char[] arr = A.toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }

        int result = 0;

        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        if (checkSecret == 4) result++;

        for (int i = P; i < S; i++) {
            int j = i - P;

            add(arr[i]);
            remove(arr[j]);

            if (checkSecret == 4) result++;
        }

        System.out.println(result);
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}

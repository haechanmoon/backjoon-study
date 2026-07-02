package woowacote.m_07.d_0702;

/*
이거 그냥 + 있는것들 다 미리 더해놓은 다음에 다 빼버리면 돼.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splits = input.split("-");
        int result = 0;
        boolean isFirst = true;

        for (String value : splits) {
            int tempSum = 0;

            String[] additionParts = value.split("\\+");

            for (String numStr : additionParts) {
                tempSum += Integer.parseInt(numStr);
            }
            if (isFirst) {
                result += tempSum;
                isFirst = false;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result);
    }
}

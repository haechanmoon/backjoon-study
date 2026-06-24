/*
* 이거 보아하니 점화식 같은데
* 매번 계산하는게 아니라
* 이미정해진거에다가 +1 하면서 늘려가는 느낌? 그러면구하기 매우 편해질듯.
* 1. dp[i] = 2*i 블록을 채울 수 있는 경우의 수
* 2. dp[i-1] , dp[i-2] 와의 관계는?
* 일단 dp가 1증가할 때마다 어떻게 늘어나는지!
* 3. 일단 초기값 dp[1] 은 1일수밖에 없죠?
* dp[2]는 2밖에 없다.
* dp[3]은 3
* dp[4]는 5
* dp[5]는 8.
* 이거dp 그거네 피보나치수열느낌이네
* dp[i] = dp[i-1] + dp[i-2] 이거네
*  */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if( n==1 ){
            System.out.print(1);
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.print(dp[n]);
    }
}

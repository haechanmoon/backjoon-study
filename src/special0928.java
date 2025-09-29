import java.util.Scanner;

public class special0928 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        sc.close();

        int score;

        score = N * 10;
        if (N >= 3) {
            score += 20;
        }
        if (N == 5) {
            score += 50;
        }

        if (W > 1000) {
            score -= 15;
        }

        int finalScore = Math.max(0, score);

        System.out.println(finalScore);
    }
}
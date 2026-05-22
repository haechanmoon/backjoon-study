import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalSum = 0;
        double creditSum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }

            double gradePoint = 0;
            switch (grade) {
                case "A+": gradePoint = 4.5; break;
                case "A0": gradePoint = 4.0; break;
                case "B+": gradePoint = 3.5; break;
                case "B0": gradePoint = 3.0; break;
                case "C+": gradePoint = 2.5; break;
                case "C0": gradePoint = 2.0; break;
                case "D+": gradePoint = 1.5; break;
                case "D0": gradePoint = 1.0; break;
                case "F": gradePoint = 0.0; break;
            }

            totalSum += (credit * gradePoint);
            creditSum += credit;
        }
        System.out.printf("%.6f\n", totalSum / creditSum);
    }
}
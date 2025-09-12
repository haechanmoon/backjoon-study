package bronze_4;

import java.util.Scanner;
import java.util.Arrays;
/*public class n_2480  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int total = 0;

        if(a==b&&b==c){
            total = 10000+a*1000;
        }
        else if(a==b||b==c||c==a){
            if(a==b)
                total = 1000+a*100;
            if(a==c)
                total = 1000+a*100;
            if(b==c)
                total = 1000+b*100;
        }
        else{
            if(a>b&&a>c){
                total = a*100;
            }
            if(b>a&&b>c){
                total = b*100;
            }
            if(c>a&&c>b){
                total = c*100;
            }
        }
        System.out.println(total);
    }
}*/

//개선된 코드!

public class n_2480 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a =  input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int total = 0;

        if(a==b&&a==c){
            total = 10000+a*1000;
        }
        else if(b==c||b==a){
            total = 1000+b*100;
        }
        else if(a==c){
            total = 1000+a*100;
        }
        else{
            int[] num = {a,b,c};
            Arrays.sort(num);
            total = num[2]*100;
        }
        System.out.println(total);
    }
}
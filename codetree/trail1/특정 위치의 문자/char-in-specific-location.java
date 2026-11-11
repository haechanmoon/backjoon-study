import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] arr = new char[] {'L', 'E', 'B', 'R', 'O', 'S'};
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        boolean flag = false;
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i]==a){
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag){
            System.out.println("None");
        }
    }
}
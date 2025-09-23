package Solved_ac.class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ageName{
    int age;
    String name;
    public ageName(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


public class n_10814 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        ageName[] Arr =  new ageName[N];
        for(int i = 0; i < N; i++){
            int age = sc.nextInt();
            String name = sc.next();

            Arr[i] = new ageName(age, name);
        }

        Arrays.sort(Arr, new Comparator<ageName>(){
            @Override
            public int compare(ageName o1, ageName o2) {
                return o1.age - o2.age;
            }
        });
        for(int i = 0; i < N; i++){
            System.out.println(Arr[i].age + " " + Arr[i].name);
        }
    }
}

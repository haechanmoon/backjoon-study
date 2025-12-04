/*
향상된 for문을 아무데나 막 갖가 쓰면 안되는구나를 깨달음.
아 배고프다.
이거 푸는데 진짜 3시간 넘게 걸렸네.
진짜 빡세다. 메서드 분리해서 구현하는거. 진짜 많이 연습해야할듯.
Main에다가 다 짜서 넣는건 이제 못하겠다. 오히려 이렇게 버릇하면.
ㅇㅈ?
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int MALE = 1;
    private static final int FEMALE = 2;

    public static void main(String[] args) throws IOException {

        int switchCount = InputView.readSwitchCount();
        SwitchBoard switchBoard = new SwitchBoard(switchCount);

        int[] initialStates = InputView.readSwitchStates(switchCount);
        for (int i = 0; i < switchCount; i++) {
            switchBoard.initSwitch(i + 1, initialStates[i]);
        }

        int studentCount = InputView.readStudentCount();
        for (int i = 0; i < studentCount; i++) {
            int[] command = InputView.readStudentCommend();
            int gender = command[0];
            int number = command[1];

            if (gender == MALE) {
                switchBoard.runMaleStrategy(number);
                continue;
            }
            switchBoard.runFemaleStrategy(number);
        }

        OutputView.printResult(switchBoard);
    }
}

class InputView{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readSwitchCount() throws IOException{
        return Integer.parseInt(br.readLine());
    }

    public static int[] readSwitchStates(int count) throws IOException{
        int[] states = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            states[i] = Integer.parseInt(st.nextToken());
        }
        return states;
    }

    public static int readStudentCount() throws IOException{
        return Integer.parseInt(br.readLine());
    }

    public static int[] readStudentCommend() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };
    }
}

class OutputView {
    public  static void printResult(SwitchBoard switchBoard){
        System.out.print(switchBoard.getResultString());
    }
}

class SwitchBoard {

    private final boolean[] switches;
    private final int size;

    public SwitchBoard(int size) {
        this.size = size;
        this.switches = new boolean[size+1];
    }

    public void initSwitch(int index, int value){
        if(value==1){
            switches[index] = true;
            return;
        }
        switches[index] = false;
    }

    public void runMaleStrategy(int number) {
        for(int i = number;i<=size;i+=number){
            toggle(i);
        }
    }

    public void runFemaleStrategy(int number) {
        toggle(number);

        int left = number-1;
        int right = number+1;

        while (isValidIndex(left,right) && isSymmetric(left,right)){
            toggle(left);
            toggle(right);
            left--;
            right++;
        }
    }

    private void toggle(int index){
        switches[index] = !switches[index];
    }

    private boolean isValidIndex(int left,int right){
        return left >=1&&right<=size;
    }

    private boolean isSymmetric(int left, int right){
        return switches[left] == switches[right];
    }

    public String getResultString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(convertStateToString(switches[i]));
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String convertStateToString(boolean isOn) {
        if (isOn) {
            return "1 ";
        }
        return "0 ";
    }
}
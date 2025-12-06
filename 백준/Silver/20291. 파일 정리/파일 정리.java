import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> fileMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            int index = fileName.indexOf('.');
            String extension = fileName.substring(index + 1);
            fileMap.put(extension, fileMap.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : fileMap.keySet()) {
            sb.append(key).append(" ").append(fileMap.get(key)).append("\n");
        }
        System.out.print(sb);
    }
}
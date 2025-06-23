import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        Map<String, Integer> lastClickMap = new HashMap<>();

        for (int i = 0; i < l; i++) {
            String studentId = br.readLine();
            lastClickMap.put(studentId, i);
        }

        ArrayList<Map.Entry<String, Integer>> waitingList = new ArrayList<>(lastClickMap.entrySet());
        waitingList.sort(Comparator.comparing(Map.Entry::getValue));
        int success = Math.min(k, waitingList.size()); //성공한 사람 수

        for (int i = 0; i < success; i++) {
            System.out.println(waitingList.get(i).getKey());
        }
    }
}

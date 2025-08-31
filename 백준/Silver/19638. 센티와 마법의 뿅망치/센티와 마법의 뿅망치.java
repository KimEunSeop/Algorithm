import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            giants.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        for (int i = 0; i < t; i++) {
            int max = giants.peek();

            if (max < h) {
                break;
            }

            if (max == 1) {
                break;
            }

            giants.poll();
            giants.add(max / 2);
            count++;
        }

        if (giants.peek() < h) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(giants.peek());
        }
    }
}

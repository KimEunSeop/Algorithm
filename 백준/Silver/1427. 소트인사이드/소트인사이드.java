import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (N > 0) {
            pq.add(Integer.valueOf(N % 10));
            N /= 10;
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll());
        }
    }
}

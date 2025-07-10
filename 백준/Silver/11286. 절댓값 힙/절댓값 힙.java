import java.util.*;
import java.io.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (plusPQ.isEmpty() && minusPQ.isEmpty()) {
                    System.out.println(0);
                }
                else if (plusPQ.isEmpty()) {
                    System.out.println(minusPQ.poll());
                }
                else if (minusPQ.isEmpty()) {
                    System.out.println(plusPQ.poll());
                }
                else {
                    int a = plusPQ.peek();
                    int b = minusPQ.peek();

                    if (a < Math.abs(b)) {
                        System.out.println(plusPQ.poll());
                    } else {
                        System.out.println(minusPQ.poll());
                    }
                }
            }
            // + 우선순위 큐
            else if (x > 0) {
                plusPQ.add(x);
            }
            // - 우선순위 큐
            else if (x < 0) {
                minusPQ.add(x);
            }
        }
    }
}

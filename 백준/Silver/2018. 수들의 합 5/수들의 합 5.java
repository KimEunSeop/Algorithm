import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1 2 3 4 5 6 7 8 9 10
        /* sum > N sum = sum - start_index; start_index++;
           sum < N end_index++; sum = sum + end_index;
           sum == N; end_index++; sum = sum + end_index; count++;
        * */
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int count = 0;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while (true){

            if (start_index == N) {
                count++;
                break;
            }

            if (sum > N) {
                sum -= start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum += end_index;
            } else {
                end_index++;
                sum += end_index;
                count++;
            }
        }

        System.out.println(count);
    }
}

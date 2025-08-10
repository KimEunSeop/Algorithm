import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int sushiNum = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속한? 접시 수
        int coupon = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            a[i] = Integer.parseInt(line.trim());
        }

        int[] count = new int[sushiNum + 1];
        int diffrent = 0;

        for (int i = 0; i < k; i++) {
            int kind = a[i];
            if (count[kind] == 0) {
                diffrent++;
            }
            count[kind] = count[kind] + 1;
        }

        int answer = diffrent;
        if (count[coupon] == 0) {
            answer = answer + 1;
        }

        for (int i = 1; i < N; i++) {
            int out = a[i - 1];
            count[out] = count[out] - 1;
            if (count[out] == 0) {
                diffrent = diffrent - 1;
            }

            int in = a[(i + k - 1) % N];
            if (count[in] == 0) {
                diffrent = diffrent + 1;
            }
            count[in] = count[in] + 1;

            int current = diffrent;
            if (count[coupon] == 0) {
                current = current + 1;
            }

            if (current > answer) {
                answer = current;
            }
            if (answer == k + 1) {
                break;
            }
        }

        System.out.println(answer);
    }
}
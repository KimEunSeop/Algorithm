import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] honey = new int[N];
        int[] sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = honey[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + honey[i];
        }

        int maxHoney = 0;

        // 벌통이 맨 오른쪽
        for (int i = 1; i < N - 1; i++) {
            int bee1 = sum[N - 1] - honey[0] - honey[i];
            int bee2 = sum[N - 1] - sum[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        // 벌통이 맨 왼쪽
        for (int i = N - 2; i > 0; i--) {
            int bee1 = sum[N - 2] - honey[i];
            int bee2 = sum[i - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        // 벌이 양 쪽
        for (int i = 1; i < N - 1; i++) {
            int bee1 = sum[i] - honey[0];
            int bee2 = sum[N - 2] - sum[i - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        System.out.println(maxHoney);
    }
}

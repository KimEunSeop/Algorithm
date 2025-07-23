import java.util.*;
import java.io.*;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        //m이상 n 이하 소수 출력

        int[] arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }
        
        arr[1] = 0;
        
        for (int i = 2; i <= sqrt(n) + 1; i++) {

            if (arr[i] == 0) continue;

            for (int j = i + i; j <= n; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (arr[i] == 0) continue;
            System.out.println(arr[i]);
        }
    }
}

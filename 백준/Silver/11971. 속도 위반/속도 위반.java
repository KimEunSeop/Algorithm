import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] limit = new int[100];
        int[] current = new int[100];

        int position = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int x = 0; x < length; x++) {
                limit[position++] = speed;
            }
        }

        position = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int x = 0; x < length; x++) {
                current[position++] = speed;
            }
        }

        int maxSpeed = 0;

        for (int i = 0; i < 100; i++) {
            maxSpeed = max(maxSpeed, current[i] - limit[i]);
        }

        System.out.println(max(maxSpeed, 0));
    }
}

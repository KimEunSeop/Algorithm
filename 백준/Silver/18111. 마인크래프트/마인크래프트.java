import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int minTime = Integer.MAX_VALUE;
        int height = -1;


        for (int h = 0; h <= 256; h++) {
            int blocksToRemove = 0;
            int blocksToAdd = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diffrence = ground[i][j] - h;

                    if (diffrence > 0) {
                        blocksToRemove += diffrence;
                    } else if (diffrence < 0) {
                        blocksToAdd += -diffrence;
                    }
                }
            }

            if (B + blocksToRemove >= blocksToAdd) {
                int time = (blocksToRemove * 2) + (blocksToAdd * 1);
                if (time <= minTime) {
                    minTime = time;
                    height = h;
                }
            }
        }

        System.out.println(minTime + " " + height);
    }
}

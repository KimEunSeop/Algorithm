import java.io.*;
import java.util.*;

public class Main {
    static final int[] otherSides = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] dice = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int f = 0; f < 6; f++) {
                dice[i][f] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int startBottom = 0; startBottom < 6; startBottom++) {
            int topValue = dice[0][otherSides[startBottom]];

            // 첫 주사위 옆면 최대값 계산
            int sum = 0;
            int maxSide = 0;
            for (int i = 0; i < 6; i++) {
                if (i == startBottom) {
                    continue;
                }
                if (i == otherSides[startBottom]) {
                    continue;
                }
                if (dice[0][i] > maxSide) {
                    maxSide = dice[0][i];
                }
            }
            sum += maxSide;

            // 나머지 주사위 처리
            for (int i = 1; i < N; i++) {
                // 바닥 인덱스
                int bottomIndex = -1;
                for (int j = 0; j < 6; j++) {
                    if (dice[i][j] == topValue) {
                        bottomIndex = j;
                        break;
                    }
                }

                int topIndex = otherSides[bottomIndex];
                topValue = dice[i][topIndex];

                // 옆면 최대값 계산
                maxSide = 0;
                for (int j = 0; j < 6; j++) {
                    if (j == bottomIndex) {
                        continue;
                    }
                    if (j == topIndex) {
                        continue;
                    }
                    if (dice[i][j] > maxSide) {
                        maxSide = dice[i][j];
                    }
                }
                sum += maxSide;
            }

            if (sum > answer) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
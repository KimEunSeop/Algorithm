import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        if (n <= 1) {
            for (int i = 0; i < r; i++) {
                sb.append(grid[i]).append("\n");
            }

        } else if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append('O');
                }
                sb.append("\n");
            }

        } else {

            int[] dr = {-1, 1, 0, 0, 0};
            int[] dc = {0, 0, -1, 1, 0};

            char[][] firstGrid = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(firstGrid[i], 'O');
            }

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (grid[j][k] == 'O') {
                        for (int i = 0; i < 5; i++) {
                            int rn = j + dr[i];
                            int cn = k + dc[i];
                            if (rn >= 0 && rn < r && cn >= 0 && cn < c) {
                                firstGrid[rn][cn] = '.';
                            }
                        }
                    }
                }
            }

            if (n % 4 == 3) {
                for (int i = 0; i < r; i++) {
                    sb.append(firstGrid[i]).append("\n");
                }
            } else {
                char[][] secondGrid = new char[r][c];
                for (int i = 0; i < r; i++) {
                    Arrays.fill(secondGrid[i], 'O');
                }

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (firstGrid[i][j] == 'O') {
                            for (int k = 0; k < 5; k++) {
                                int rn = i + dr[k];
                                int cn = j + dc[k];
                                if (rn >= 0 && rn < r && cn >= 0 && cn < c) {
                                    secondGrid[rn][cn] = '.';
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < r; i++) {
                    sb.append(secondGrid[i]).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}

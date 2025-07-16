import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[cx][cy] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

}

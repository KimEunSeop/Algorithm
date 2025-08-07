import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = true;
        }

        int maxSize = 0;

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (map[y][x] && !visited[y][x]) {
                    int size = bfs(y, x);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(maxSize);
    }

    static int bfs(int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy, sx});
        visited[sy][sx] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny >= 1 && ny <= N && nx >= 1 && nx <= M) {
                    if (map[ny][nx] && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

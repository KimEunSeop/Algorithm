import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Virus implements Comparable<Virus> {
        int x, y, number, time;

        public Virus(int x, int y, int number, int time) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Virus other) {
            return this.number - other.number;
        }
    }

    static int n;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        ArrayList<Virus> initialViruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] != 0) {
                    initialViruses.add(new Virus(i, j, grid[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        Collections.sort(initialViruses);

        Queue<Virus> q = new LinkedList<>(initialViruses);

        bfs(q, s);

        System.out.println(grid[targetX - 1][targetY - 1]);
    }

    private static void bfs(Queue<Virus> q, int S) {
        while (!q.isEmpty()) {
            Virus current = q.poll();

            if (current.time == S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    grid[nx][ny] = current.number;
                    q.add(new Virus(nx, ny, current.number, current.time + 1));
                }
            }
        }
    }
}

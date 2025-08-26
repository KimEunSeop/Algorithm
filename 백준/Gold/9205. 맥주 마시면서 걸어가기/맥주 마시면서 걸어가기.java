import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Point> locations = new ArrayList<>();

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                locations.add(new Point(x, y));
            }

            if (bfs(n, locations)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    public static boolean bfs(int n, ArrayList<Point> locations) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            Point currentPoint = locations.get(currentIndex);

            if (currentIndex == n + 1) {
                return true;
            }

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i]) {
                    Point nextPoint = locations.get(i);
                    int distance = Math.abs(currentPoint.x - nextPoint.x) + Math.abs(currentPoint.y - nextPoint.y);

                    if (distance <= 1000) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }

        return false;
    }
}
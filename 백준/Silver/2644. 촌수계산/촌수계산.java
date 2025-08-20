import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            adjList[parent].add(child);
            adjList[child].add(parent);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];

        queue.add(person1);
        distance[person1] = 0;

        int result = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == person2) {
                result = distance[current];
                break;
            }

            for (int next : adjList[current]) {
                if (distance[next] == 0) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        if (person1 != person2 && distance[person2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
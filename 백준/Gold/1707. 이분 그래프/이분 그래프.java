import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] check;
    static boolean isAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점 수
            int e = Integer.parseInt(st.nextToken()); // 간선 수

            graph = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            check = new int[v + 1]; // 0: 미방문, 1과 -1: 양쪽
            isAnswer = true;

            for (int i = 1; i <= v; i++) {
                if (check[i] == 0) {
                    bfs(i);
                }
            }

            if(isAnswer){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = 1;

        while (!queue.isEmpty() && isAnswer) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (check[next] == 0) {
                    check[next] = -check[cur];
                    queue.offer(next);
                } else if (check[next] == check[cur]) {
                    isAnswer = false;
                    return;
                }
            }
        }
    }
}

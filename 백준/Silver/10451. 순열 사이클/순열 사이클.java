import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        돌면서 사이클 끝날때마다 ++
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] array = new int[n + 1]; // 순열 저장할 곳
            boolean[] visited = new boolean[n + 1]; // 방문 여부 체크

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int k = 1; k <= n; k++) {
                if (!visited[k]) {//방문 안한 놈 찾음
                    answer++;
                    int current = k;
                    while (!visited[current]) {
                        visited[current] = true;
                        current = array[current];
                    }
                }
            }

            System.out.println(answer);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Task implements Comparable<Task> {
        int t;
        int s;

        public Task(int T, int S) {
            this.t = T;
            this.s = S;
        }

        @Override
        public int compareTo(Task o) {
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(t, s);
        }

        Arrays.sort(tasks);

        int time = tasks[0].s;

        for (Task task : tasks) {
            if (time > task.s) {
                time = task.s;
            }
            time -= task.t;
        }
        
        if (time < 0) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }
    }
}
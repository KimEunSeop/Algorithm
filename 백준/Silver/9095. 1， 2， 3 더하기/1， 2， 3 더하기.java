import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] d = new int[11];  // n 최대가 10
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i <= 10; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}

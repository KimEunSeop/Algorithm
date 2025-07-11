import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int max = arr[N - 1];

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ((double) arr[i] / max) * 100;
        }

        System.out.println(sum / N);
    }
}

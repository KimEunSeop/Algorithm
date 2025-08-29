import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int n2 = Integer.parseInt(br.readLine());
            int[] arr = new int[n2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n2; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] evenArr;
            int[] oddArr;

            if (n2 % 2 == 0) {
                evenArr = new int[n2 / 2];
                oddArr = new int[n2 / 2];
            } else {
                evenArr = new int[n2 / 2 + 1];
                oddArr = new int[n2 / 2];
            }

            int evenIdx = 0;
            int oddIdx = 0;

            for (int j = 0; j < n2; j++) {
                if (j % 2 == 0) {
                    evenArr[evenIdx] = arr[j];
                    evenIdx++;
                } else {
                    oddArr[oddIdx] = arr[j];
                    oddIdx++;
                }
            }

            int idx = 0;

            for (int j = 0; j < evenArr.length; j++) {
                arr[idx] = evenArr[j];
                idx++;
            }

            for (int j = oddArr.length - 1; j >= 0; j--) {
                arr[idx] = oddArr[j];
                idx++;
            }

            int max = 0;

            for (int j = 1; j < n2; j++) {
                int temp = Math.abs(arr[j - 1] - arr[j]);
                if (temp > max) {
                    max = temp;
                }
            }

            System.out.println(max);
        }
    }
}

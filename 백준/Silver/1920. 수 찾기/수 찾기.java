import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1);

        for (int i = 0; i < m; i++) {
            int target = arr2[i];
            int left = 0;
            int right = n - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr1[mid] == target) {
                    found = true;
                    break;
                } else if (arr1[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (found) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
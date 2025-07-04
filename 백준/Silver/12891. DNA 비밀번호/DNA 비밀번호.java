import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();
        int[] condition = new int[4]; // A C G T

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }

        int first_index = 0;
        int end_index = P - 1;

        int[] status = new int[4];

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int count = 0;

        for (int i = 0; i < P; i++) {
            status[map.get(DNA.charAt(i))]++;
        }

        for (int i = 0; i < 4; i++) {
            if (status[i] < condition[i]) {
                break;
            }
            if (i == 3) {
                count++;
            }
        }

        while (end_index < S - 1) {
            status[map.get(DNA.charAt(first_index))]--;
            first_index++;
            end_index++;
            status[map.get(DNA.charAt(end_index))]++;

            for (int i = 0; i < 4; i++) {
                if (status[i] < condition[i]) {
                    break;
                }
                if (i == 3) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

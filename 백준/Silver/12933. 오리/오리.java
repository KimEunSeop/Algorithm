import java.util.*;
import java.io.*;

public class Main {
    private static final char[] QUACK = {'q','u','a','c','k'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int remain = arr.length;
        int ducks = 0;

        while (remain > 0) {
            int quackIdx = 0;       // quack 문자 인덱스
            boolean found = false;
            int[] positions = new int[5];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == QUACK[quackIdx]) {
                    positions[quackIdx] = i;
                    quackIdx++;
                    if (quackIdx == 5) {
                        found = true;
                        remain -= 5;
                        // 사용한 문자들을 지워버려
                        for (int k = 0; k < 5; k++) {
                            arr[positions[k]] = 0;
                        }
                        quackIdx = 0;
                    }
                }
            }

            if (!found) {
                System.out.println(-1);
                return;
            }

            ducks++;
        }

        System.out.println(ducks);
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int target_index = 0;
        Integer i = (Integer) 1;

        while (true) {
            if (target_index == n) {
                System.out.println(sb.toString());
                break;
            }

            if (i > n + 1) {
                System.out.println("NO");
                break;
            }

            if (stack.isEmpty() || stack.peek() < arr[target_index]) {
                sb.append("+\n");
                stack.push(i);
                i++;
            } else if (stack.peek() == arr[target_index]) {
                sb.append("-\n");
                stack.pop();
                target_index++;
            } else {
                System.out.println("NO");
                break;
            }
        }
    }
}


// 수열 입력 받아
// 수열 첫번째 값 타겟으로 잡아

// 수열 반복문 돌려 top == target? -> 뻬
//                  != target -> 더해
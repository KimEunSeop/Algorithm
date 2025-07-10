import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = N; i > 0; i--) {
            deque.addFirst((Integer)i);
        }

        boolean flag = true;

        while (deque.size() != 1) {
            if(flag == true){
                flag = false;
                deque.removeFirst();
            }
            else if(flag == false){
                flag = true;
                Integer temp = deque.removeFirst();
                deque.addLast(temp);
            }
        }

        System.out.println(deque.pop());
    }
}

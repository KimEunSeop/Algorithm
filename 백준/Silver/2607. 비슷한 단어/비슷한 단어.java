import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            char[] temp = word.toCharArray();
            int check = 0;
            String s = br.readLine();

            if (Math.abs(word.length() - s.length()) <= 1) {
                for (int j = 0; j < s.length(); j++) {
                    for (int k = 0; k < temp.length; k++) {
                        if (temp[k] == s.charAt(j)) {
                            check++;
                            temp[k] = 'a';
                            break;
                        }
                    }
                }

                if (word.length() - s.length() == 0) {
                    if (check >= word.length() - 1) {
                        answer++;
                    }
                } else if (word.length() - s.length() == 1) {
                    if(check == s.length()) {
                        answer++;
                    }
                } else if (s.length() - word.length() == 1) {
                    if(check == word.length()) {
                        answer++;
                    }
                }

                check = 0;
            }
        }

        System.out.println(answer);
    }
}

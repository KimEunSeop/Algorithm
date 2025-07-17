import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        String[] splitByMinus = formula.split("-");

        int result = 0;
        
        String[] front = splitByMinus[0].split("\\+");
        for (int i = 0; i < front.length; i++) {
            result += Integer.parseInt(front[i]);
        }
        
        for (int i = 1; i < splitByMinus.length; i++) {
            String[] temp = splitByMinus[i].split("\\+");
            int minusSum = 0;
            for (int j = 0; j < temp.length; j++) {
                minusSum += Integer.parseInt(temp[j]);
            }
            result -= minusSum;
        }

        System.out.println(result);
    }
}

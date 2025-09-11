import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stayCount = new int[N + 2];
        
        for (int s : stages) {
            if (s <= N) {
                stayCount[s]++;
            }
        }
        
        List<Stage> list = new ArrayList<>();
        double count = stages.length;
        
        for (int i = 1; i <= N; i++) {
            double failRate;
            if (count == 0) {
                failRate = 0.0;
            } else {
                failRate = stayCount[i] / count;
            }
            list.add(new Stage(i, failRate));
            count -= stayCount[i];
        }
        
        Collections.sort(list, new Comparator<Stage>() {
            public int compare(Stage a, Stage b) {
                if (Double.compare(b.failRate, a.failRate) != 0) {
                    return Double.compare(b.failRate, a.failRate);
                } else {
                    return a.stage - b.stage;
                }
            }
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).stage;
        }
        return answer;
    }
    
    static class Stage {
        int stage;
        double failRate;
        Stage(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
}
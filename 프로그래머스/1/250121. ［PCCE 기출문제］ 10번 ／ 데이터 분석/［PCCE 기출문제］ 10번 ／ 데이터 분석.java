import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int idx1 = map.get(ext);
        int idx2 = map.get(sort_by);

        List<int[]> list = new ArrayList<>();
        for (int[] row : data) {
            if (row[idx1] < val_ext) {
                list.add(row);
            }
        }

        Collections.sort(list, (a, b) -> a[idx2] - b[idx2]);

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
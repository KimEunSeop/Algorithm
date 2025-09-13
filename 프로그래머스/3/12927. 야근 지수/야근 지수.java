import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        //작업량 제곱의 합 = 야근 피로도
        //1시간 = 작업량 1
        //퇴근까지 남은 시간 -> 각 일에 대한 작업량의 피로도 최솟값 -> 골고루 해야 하겠네
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Integer a[] = Arrays.stream(works).boxed().toArray(Integer[]::new); 
        
        for (Integer work : a) {
            pq.add(work);
        }
        
        for (int i = 0; i < n; i++){
            Integer temp = pq.poll();
            if (temp == 0) {
                break;
            }
            temp--;
            pq.add(temp);
        }
        
        Long result = 0L;
        
        while (pq.size() != 0) {
            Integer temp = pq.poll();
            result += temp * temp;
        }
        
        long answer = 0;
        
        answer = result.longValue();
        return answer;
    }
}
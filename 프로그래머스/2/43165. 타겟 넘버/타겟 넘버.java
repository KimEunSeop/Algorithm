class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    private void dfs(int[] numbers, int depth, int target, int calc) {
        // 모든 numbers를 연산한 경우
        if (depth == numbers.length) {
            if (calc == target) {
                answer++;
            }
            
            return;
        } else {
            dfs(numbers, depth + 1, target, calc + numbers[depth]);
            dfs(numbers, depth + 1, target, calc - numbers[depth]);
        }
    }
}
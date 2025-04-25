class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int count = 0;

            for (int j = 0; j < 7; j++) {
                int weekday = (startday + j - 1) % 7 + 1;
                if (weekday == 6 || weekday == 7) continue; 

                if (isAttendance(i, j, schedules, timelogs)) {
                    count++;
                }
            }

            if (count == 5) {
                answer++;
            }
        }

        return answer;
    }

    boolean isAttendance(int i, int j, int[] schedules, int[][] timelogs) {
        int maxTime = schedules[i] + 10;

        // 60분 초과 보정
        if (maxTime % 100 >= 60) {
            maxTime = (maxTime / 100 + 1) * 100 + (maxTime % 100 - 60);
        }
        return timelogs[i][j] <= maxTime;
    }
}

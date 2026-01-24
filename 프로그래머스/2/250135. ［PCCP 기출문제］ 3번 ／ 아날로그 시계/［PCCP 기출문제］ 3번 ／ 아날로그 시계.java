import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        for (int i = start; i < end; i++) {
            double hCur = (i * (1.0 / 120.0)) % 360;
            double mCur = (i * 0.1) % 360;
            double sCur = (i * 6.0) % 360;

            double hNext = ((i + 1) * (1.0 / 120.0)) % 360;
            double mNext = ((i + 1) * 0.1) % 360;
            double sNext = ((i + 1) * 6.0) % 360;

            if (hNext == 0) hNext = 360;
            if (mNext == 0) mNext = 360;
            if (sNext == 0) sNext = 360;

            boolean hMatch = sCur < hCur && sNext >= hNext;
            boolean mMatch = sCur < mCur && sNext >= mNext;

            if (hMatch == true && mMatch ==true) {
                if (hNext == mNext) answer++;
                else answer += 2;
            } else if ((hMatch == true && mMatch == false) || (hMatch == false && mMatch == true )) {
                answer++;
            }
        }

        if (start == 0 || start == 43200) answer++; //시작 했는데 같을때

        return answer;
    }
}
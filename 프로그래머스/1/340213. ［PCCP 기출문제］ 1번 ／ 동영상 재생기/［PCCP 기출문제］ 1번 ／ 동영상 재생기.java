public class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int totalTime = parse(video_len);
        int time = parse(pos);

        for (String command : commands) {
            if ((time >= parse(op_start)) && (time <= parse(op_end))) {
                time = parse(op_end);
            }
            if (command.equals("prev")) {
                if (time <= 10) {
                    time = 0;
                    continue;
                }
                time -= 10;
            }
            if (command.equals("next")) {
                if (totalTime - time <= 10) {
                    time = totalTime;
                    continue;
                }
                time += 10;
            }
            if ((time >= parse(op_start)) && (time <= parse(op_end))) {
                time = parse(op_end);
            }
        }

        return convert(time);
    }

    private String convert(int time) {
        int a = time / 60;
        int b = time % 60;
        String A = String.format("%d", a);
        if (a < 10) {
            A = String.format("0" + A);
        }
        String B = String.format("%d", b);
        if (b < 10) {
            B = String.format("0" + B);
        }
        return String.format(A + ":" + B);
    }

    public int parse(String pos) {
        return Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3, 5));
    }
}

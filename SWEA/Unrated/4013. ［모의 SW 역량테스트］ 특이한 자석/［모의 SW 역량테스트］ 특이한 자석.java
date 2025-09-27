import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test_case = 1; test_case <= t; test_case++) {
            int k = sc.nextInt(); // 회전 횟수

            // 자석 4개, 각각 8칸
            int[][] magnets = new int[4][8];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = sc.nextInt();
                }
            }

            // 회전 정보 K개
            int[][] rotations = new int[k][2];
            for (int i = 0; i < k; i++) {
                rotations[i][0] = sc.nextInt(); // 자석 번호
                rotations[i][1] = sc.nextInt(); // 방향 1시계 -1반시계
            }

            // K번 회전 수행
            for (int i = 0; i < k; i++) {
                int p = rotations[i][0] - 1; // 자석 index
                int dir = rotations[i][1];

                int[] dirs = new int[4];
                dirs[p] = dir;

                // 왼쪽 전파
                for (int j = p; j > 0; j--) {
                    if (magnets[j][6] != magnets[j-1][2]) {
                        dirs[j-1] = -dirs[j];
                    } else break;
                }

                // 오른쪽 전파
                for (int j = p; j < 3; j++) {
                    if (magnets[j][2] != magnets[j+1][6]) {
                        dirs[j+1] = -dirs[j];
                    } else break;
                }

                // 실제 회전 적용
                for (int j = 0; j < 4; j++) {
                    if (dirs[j] == 1) {
                        // 시계 방향
                        int temp = magnets[j][7];
                        for (int x = 7; x > 0; x--) {
                            magnets[j][x] = magnets[j][x-1];
                        }
                        magnets[j][0] = temp;
                    } else if (dirs[j] == -1) {
                        // 반시계 방향
                        int temp = magnets[j][0];
                        for (int x = 0; x < 7; x++) {
                            magnets[j][x] = magnets[j][x+1];
                        }
                        magnets[j][7] = temp;
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) {
                if (magnets[i][0] == 1) {
                    int j = 0;
                    int temp = 1;
                    while (true) {
                        if (j == i){
                            break;
                        }

                        temp *=2;
                        j++;
                    }
                    answer += temp;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}

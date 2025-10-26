class Solution {
    static int[] server;

    public int solution(int[] players, int m, int k) {
        
        int totalCount = 0;
        server = new int[players.length];
        
        for(int i = 0; i < players.length; i++){

            int needServer = 0;
            if(players[i] >= m){
                needServer += ((players[i] - m) / m) + 1;
            }
            
            int serverCount = 0;
            for(int j = Math.max(0, i - k + 1); j < i; j++){
                serverCount += server[j];
            }
            
            //필요한 서버 수
            int add = Math.max(0, needServer - serverCount);
            server[i] = add;
            totalCount += add;
            
        }
        return totalCount;
    }
}
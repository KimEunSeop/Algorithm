import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
         
        // 맵에 players 옮기기 -> n
        // callings 반복문 돌리면서 맵의 값 swap 하기? -> n
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for (String call : callings){
            int index = map.get(call);
            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;
            
            map.put(players[index - 1], index -1);
            map.put(players[index], index);
        }
        
//         System.out.println(map);
        
        return players;
    }
}
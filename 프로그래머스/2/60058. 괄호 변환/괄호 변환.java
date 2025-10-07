import java.util.*;

class Solution {
    public String solution(String p) {
        
        return method(p);
    }
    
    public String method (String p) {
        //1
        if (p.length() == 0) {
            return p;
        }
        
        //2
        String u = findU(p);
        String v = p.substring(u.length(), p.length());
        
        //3
        if(checkU(u)) {
            return u + method(v);
        } else {
            //4
            return "(" + method(v) + ")" + treatU(u);
        }
    }
    
    public String findU(String p) {
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '('){
                count1++;
            } else {
                count2++;
            }
            if(count1 == count2) {
                return p.substring(0, count1 + count2);
            }
        }
        
        return p;
    }
    
    public boolean checkU (String u) {
        int count = 0;
        for(int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') count ++;
            else count --;
            if(count < 0) {
                return false;
            }
        }
        return true;
    }
    
    public String treatU(String u) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }
        
        
        return sb.toString();
    }
}

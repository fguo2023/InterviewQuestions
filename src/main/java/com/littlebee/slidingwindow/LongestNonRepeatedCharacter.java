package com.littlebee.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatedCharacter {
    public int lengthOfLongestSubstring(String s) {
        //abcabcbb
        // Time: O(n) Space: O(1)
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int l = 0,r = 0;
        int count = 1;
        while(r < len){
            char right = s.charAt(r);
            if(!set.contains(right)){
                set.add(right);
                r++;
            }else{
                count = Math.max(count, r - l);
                while(l < r){
                    char left = s.charAt(l);
                    set.remove(left);
                    if(left == right){
                        l++;
                        break;
                    }
                    l++;
                }
            }
        }
        count = Math.max(count, r - l);
        return count;
    }
}

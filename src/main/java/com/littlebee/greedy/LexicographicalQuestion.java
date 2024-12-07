package com.littlebee.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LexicographicalQuestion {
    /**
     * find the smallest lexicographical string from the input String[]
     * [b,ba] -->bab
     * [abc, cde, ft] -->abccdeft
     */
    // this question is hard to verify, the only way to verify is to form all the possible string and then find the least
    public String findSmallest(String[] input){
        if(input == null || input.length == 0) return "";
        Arrays.sort(input, new MyComparator());
        String ans = "";
        for (int i = 0; i < input.length; i++) {
            ans += input[i];
        }
        return ans;
    }

    class MyComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return (s1+s2).compareTo(s2+s1);
        }
    }

}

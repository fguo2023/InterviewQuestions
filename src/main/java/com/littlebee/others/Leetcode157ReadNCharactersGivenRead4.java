package com.littlebee.others;

public class Leetcode157ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        // means we need to read n characters from the file
        // n could be < = or > than the total numbers of characters in the file
        // read4() method each time reads only 4 characters each round and return the number of characters it reads
        // char[] stores all the read characters and then return the length to the function
        int index = 0;
        while (n > 0) {
            char[] buf4 = new char[4];
            int count = read4(buf4); // this is an method from the Read4 interfaces which reads a file and each time by 4 characters
            if (count == 0) break; // there are no more characters in the file to read
            if (count > 0) {
                for (int i = 0; i < count && n > 0; i++) { // when first implementation, miss then n > 0 and miss the n-- each time when copy to the buf array
                    buf[index++] = buf4[i];
                    n--; // the case miss is when n = 5 and input is leetc | ode ==> output is leetc, we only need to read the 5 characters total, but file still have the number of characters > existing n characters
                }
            }
            if (count < 4) break;
            // n -= count; // here is not the correct way to implement (first time to put here)
        }
        return index;
    }
    // below method is to simulate a method that could be on the Read4 class
    public int read4(char[] buf) {
        return 0;
    }
}

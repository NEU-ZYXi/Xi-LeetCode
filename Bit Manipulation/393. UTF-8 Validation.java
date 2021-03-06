
/*

A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, 
followed by n-1 bytes with most significant 2 bits being 10.

This is how the UTF-8 encoding would work:
   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

*/

/*

O(n),O(1)

*/

public boolean validUtf8(int[] data) {
    int cnt = 0;
    for (int n : data) {
        if (cnt == 0) {
            if ((n >> 5) == 0b110) cnt = 1;
            else if ((n >> 4) == 0b1110) cnt = 2;
            else if ((n >> 3) == 0b11110) cnt = 3;
            else if ((n >> 7) != 0) return false;
        } else {
            if ((n >> 6) != 0b10) return false;
            cnt--;
        }
    }
    return cnt == 0;
}





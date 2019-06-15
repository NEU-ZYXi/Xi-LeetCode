
/*

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅', 
where '∅' is defined as the blank character which is less than any other character.

*/

/*

O(nm),O(1)

*/

public boolean isAlienSorted(String[] words, String order) {
    int[] map = new int[26];
    for (int i = 0; i < order.length(); ++i) {
        map[order.charAt(i) - 'a'] = i;
    }
    for (int i = 1; i < words.length; ++i) {
        if (compare(map, words[i - 1], words[i]) > 0) {
            return false;
        }
    }
    return true;
}

private int compare(int[] map, String a, String b) {
    int n = a.length(), m = b.length(), cmp = 0;
    for (int i = 0, j = 0; i < n && j < m && cmp == 0; ++i, ++j) {
        cmp = map[a.charAt(i) - 'a'] - map[b.charAt(j) - 'a'];
    }
    return cmp == 0 ? n - m : cmp;
}





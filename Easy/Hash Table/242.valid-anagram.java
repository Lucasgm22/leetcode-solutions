/*
 * 242. Valid Anagram
 * Difficulty: Easy
 * https://leetcode.com/problems/valid-anagram/
 *
 * ──────────────────────────────────────────────────
 *
 * Given two strings s and t, return true if t is an anagram of s, and
 * false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= s.length, t.length <= 5 * 10^4
 *
 * 	• s and t consist of lowercase English letters.
 *
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would
 * you adapt your solution to such a case?
 *
 * O(|s|) in time
 * O(1) in space
*/

class Solution {
    private static int ALPHABET_SIZE = 26;

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] lookup = new int[ALPHABET_SIZE];

        for (int i = 0; i < s.length(); i++) {
            lookup[s.charAt(i) - 'a']++;
            lookup[t.charAt(i) - 'a']--;
        }

        for (int count: lookup)
            if (count > 0)
                return false;

        return true;
    }
}

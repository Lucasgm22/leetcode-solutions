/*
 * 383. Ransom Note
 * Difficulty: Easy
 * https://leetcode.com/problems/ransom-note/
 *
 * ──────────────────────────────────────────────────
 *
 * Given two strings ransomNote and magazine, return true if ransomNote
 * can be constructed by using the letters from magazine and false
 * otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= ransomNote.length, magazine.length <= 10^5
 *
 * 	• ransomNote and magazine consist of lowercase English letters.
 *
 * 	O(|ransomNote| + |magazine|) in time
 * 	O(1) in space
*/

class Solution {

    private static final int ALPHABET_SIZE = 26;

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] lookup = new int[ALPHABET_SIZE];

        for (int i = 0; i < magazine.length(); i++) lookup[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++) if (lookup[ransomNote.charAt(i) - 'a']-- == 0) return false;

        return true;
    }
}

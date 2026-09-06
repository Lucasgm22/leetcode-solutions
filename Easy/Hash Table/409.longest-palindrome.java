/*
 * 409. Longest Palindrome
 * Difficulty: Easy
 * https://leetcode.com/problems/longest-palindrome/
 *
 * ──────────────────────────────────────────────────
 *
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with
 * those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a
 * palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd",
 * whose length is 7.
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose
 * length is 1.
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= s.length <= 2000
 *
 * 	• s consists of lowercase and/or uppercase English letters only.
 *
 * 	O(|s|) in time O(1) in space
*/

class Solution {

    private static int ASCII_SIZE = 128;

    public int longestPalindrome(String s) {
        int[] freqMap = new int[ASCII_SIZE];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            freqMap[curr] += 1;
            if (freqMap[curr] == 2) {
                count += 2;
                freqMap[curr] = 0;
            }
        }

        return count + (count < s.length() ? 1 : 0);
    }
}

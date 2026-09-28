/*
 * 14. Longest Common Prefix
 * Difficulty: Easy
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * ──────────────────────────────────────────────────
 *
 * Write a function to find the longest common prefix string amongst an
 * array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= strs.length <= 200
 *
 * 	• 0 <= strs[i].length <= 200
 *
 * • strs[i] consists of only lowercase English letters if it is
 * non-empty.
 *
 * O(1) in space
 * O(|strs|*min(|str|))
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean isCommonPrefix = true;

        while (isCommonPrefix) {
            for (String str: strs) {
                if (i >= str.length() || str.charAt(i) != strs[0].charAt(i)) {
                    isCommonPrefix = false;
                    break;
                }
            }
            if (isCommonPrefix)
                sb.append(strs[0].charAt(i++));
        }

        return sb.toString();
    }
}

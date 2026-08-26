/*
 * 125. Valid Palindrome
 * Difficulty: Easy
 * https://leetcode.com/problems/valid-palindrome/
 *
 * ──────────────────────────────────────────────────
 *
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters
 * include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false
 * otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= s.length <= 2 * 10^5
 *
 * 	• s consists only of printable ASCII characters.
 *
 * O(|s|) in time
 * O(1) in space
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (right > left) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!isAlphaNumeric(cLeft)) {
                left++;
                continue;
            }
            if (!isAlphaNumeric(cRight)) {
                right--;
                continue;
            }

            if (!isEqualsIgnoreCase(cLeft, cRight)) return false;

            left++;
            right--;
        }
        return true;
    }

    public boolean isEqualsIgnoreCase(char cLeft, char cRight) {
        if (cLeft == cRight) return true;

        if (isAlpha(cLeft) && isAlpha(cRight)) {
            if (cLeft == cRight + ('a' - 'A')) return true;

            if (cLeft + ('a' - 'A') == cRight) return true;
        }

        return false;
    }
    public boolean isAlphaNumeric(char c) {
        return isNumeric(c) || isAlpha(c);
    }

    public boolean isAlpha(char c) {
        return  'a' <= c && c <= 'z'
            || 'A' <= c && c <= 'Z';
    }

    public boolean isNumeric(char c) {
        return '0' <= c && c <= '9';
    }
}

/*
 * 67. Add Binary
 * Difficulty: Easy
 * https://leetcode.com/problems/add-binary/
 *
 * ──────────────────────────────────────────────────
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 *
 * Constraints:
 *
 * 	• 1 <= a.length, b.length <= 10^4
 *
 * 	• a and b consist only of '0' or '1' characters.
 *
 * • Each string does not contain leading zeros except for the zero
 * itself.
 *
 * O(max(|a|, |b|)) in time O(1) in space
*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            int curDigit = carry;
            if (i >= 0) curDigit += a.charAt(i--) - '0';
            if (j >= 0) curDigit += b.charAt(j--) - '0';
            // curDigit is one of 00, 01, 10 , 11 in base 2
            sb.append(curDigit % 2);
            carry = curDigit >> 1;
        }
        return sb.reverse().toString();
    }
}

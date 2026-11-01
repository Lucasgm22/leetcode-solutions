"""
67. Add Binary
Difficulty: Easy
https://leetcode.com/problems/add-binary/

──────────────────────────────────────────────────

Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"



Constraints:

	• 1 <= a.length, b.length <= 10^4

	• a and b consist only of '0' or '1' characters.

• Each string does not contain leading zeros except for the zero
itself.
O(max(|a|, |b|)) in time
O(1) in space
"""

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        i = len(a) - 1
        j = len(b) - 1
        ans = []

        while carry > 0 or i >= 0 or j >= 0:
            if i >= 0:
                carry += int(a[i])
                i -= 1
            if j >= 0:
                carry += int(b[j])
                j -= 1
            ans.append(str(carry % 2))
            carry //= 2

        return ''.join(reversed(ans))



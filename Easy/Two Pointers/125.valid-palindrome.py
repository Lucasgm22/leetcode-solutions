"""
125. Valid Palindrome
Difficulty: Easy
https://leetcode.com/problems/valid-palindrome/

──────────────────────────────────────────────────

A phrase is a palindrome if, after converting all uppercase letters
into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters
include letters and numbers.

Given a string s, return true if it is a palindrome, or false
otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric
characters.
Since an empty string reads the same forward and backward, it is a
palindrome.



Constraints:

	• 1 <= s.length <= 2 * 10^5

	• s consists only of printable ASCII characters.
O(|s|) in time
O(1) in space
"""

class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1

        while left < right:
            while not s[left].isalnum() and left < right:
                left = left + 1

            while not s[right].isalnum() and left < right:
                right = right - 1

            if s[left].upper() != s[right].upper():
                return False;
            else:
                left = left + 1
                right = right - 1

        return True

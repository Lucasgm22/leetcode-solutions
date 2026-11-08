"""
844. Backspace String Compare
Difficulty: Easy
https://leetcode.com/problems/backspace-string-compare/

──────────────────────────────────────────────────

Given two strings s and t, return true if they are equal when both
are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue
empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".



Constraints:

	• 1 <= s.length, t.length <= 200

	• s and t only contain lowercase letters and '#' characters.



Follow up: Can you solve it in O(n) time and O(1) space?
O(|s| + |t|) in time
O(1) in space
"""

class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        i = len(s) - 1
        j = len(t) - 1
        skipS = 0
        skipT = 0

        while i >= 0 or j >= 0:
            while i >= 0:
                if s[i] == '#':
                    skipS += 1
                    i -= 1
                elif skipS > 0:
                    skipS -= 1
                    i -= 1
                else:
                    break

            while j >= 0:
                if t[j] == '#':
                    skipT += 1
                    j -= 1
                elif skipT > 0:
                    skipT -= 1
                    j -= 1
                else:
                    break

            if i >= 0 and j >= 0 and (s[i] != t[j]):
                return False
            if (i >= 0) != (j >= 0):
                return False
            i -= 1
            j -= 1

        return True

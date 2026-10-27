"""
383. Ransom Note
Difficulty: Easy
https://leetcode.com/problems/ransom-note/

──────────────────────────────────────────────────

Given two strings ransomNote and magazine, return true if ransomNote
can be constructed by using the letters from magazine and false
otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true



Constraints:

	• 1 <= ransomNote.length, magazine.length <= 10^5

	• ransomNote and magazine consist of lowercase English letters.
O(|magazine|) in time
O(1) in space
"""

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        freq = {}
        for char in magazine:
            freq[char] = freq.get(char, 0) + 1

        for char in ransomNote:
            curFreq = freq.get(char, 0)
            if curFreq <= 0:
                return False
            freq[char] = curFreq - 1

        return True

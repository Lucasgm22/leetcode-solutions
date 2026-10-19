"""
704. Binary Search
Difficulty: Easy
https://leetcode.com/problems/binary-search/

──────────────────────────────────────────────────

Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums. If
target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1



Constraints:

	• 1 <= nums.length <= 10^4

	• -10^4 < nums[i], target < 10^4

	• All the integers in nums are unique.

	• nums is sorted in ascending order.
"""

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        i_left = 0
        i_right = len(nums) - 1

        while i_left <= i_right:
            i_mid = i_left + ((i_right - i_left) // 2)
            if nums[i_mid] == target:
                return i_mid
            elif target > nums[i_mid]:
                i_left = i_mid + 1
            else:
                i_right = i_mid - 1
        return -1

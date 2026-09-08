/*
 * 169. Majority Element
 * Difficulty: Easy
 * https://leetcode.com/problems/majority-element/
 *
 * ──────────────────────────────────────────────────
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than &lfloor;n
 * / 2&rfloor; times. You may assume that the majority element always
 * exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 * 	• n == nums.length
 *
 * 	• 1 <= n <= 5 * 10^4
 *
 * 	• -10^9 <= nums[i] <= 10^9
 *
 * • The input is generated such that a majority element will exist in
 * the array.
 *
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1)
 * space?
 *
 * O(|nums|) in time
 * O(1) in space
*/

class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int cnt = 0;

        for (int num: nums) {
            if (cnt == 0) {
                majority = num;
                cnt++;
            } else {
                cnt += num == majority ? 1 : -1;
            }
        }

        return majority;
    }
}

"""
110. Balanced Binary Tree
Difficulty: Easy
https://leetcode.com/problems/balanced-binary-tree/

──────────────────────────────────────────────────

Given a binary tree, determine if it is height-balanced.



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true



Constraints:

	• The number of nodes in the tree is in the range [0, 5000].

	• -10^4 <= Node.val <= 10^4
O(|root|) in time
O(height(|root|)) in space
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode | None) -> bool:
        return self.isBalancedHeight(root) != -1

    def isBalancedHeight(self, root: TreeNode | None) -> int:
        if root is None:
            return 0;
        hLeft = self.isBalancedHeight(root.left)
        if (hLeft == -1):
            return -1
        hRight = self.isBalancedHeight(root.right)
        if (hRight == -1):
            return -1
        if abs(hRight - hLeft) > 1:
            return - 1
        return max(hRight, hLeft) + 1


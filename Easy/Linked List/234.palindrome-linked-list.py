"""
234. Palindrome Linked List
Difficulty: Easy
https://leetcode.com/problems/palindrome-linked-list/

──────────────────────────────────────────────────

Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.



Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false



Constraints:

	• The number of nodes in the list is in the range [1, 10^5].

	• 0 <= Node.val <= 9



Follow up: Could you do it in O(n) time and O(1) space?
O(|head|) in time
O(1) in space
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode | None) -> bool:
        if head is None or head.next is None:
            return True

        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        secondHalfHead = self.reverse(slow)

        p1 = head
        p2 = secondHalfHead
        isPalin = True

        while p2 is not None:
            if p1.val != p2.val:
                isPalin = False
                break
            p1 = p1.next
            p2 = p2.next

        self.reverse(secondHalfHead)

        return isPalin

    def reverse(self, head: ListNode | None) -> ListNode | None:
        prev = None
        while head is not None:
            nextTemp = head.next
            head.next = prev
            prev = head
            head = nextTemp

        return prev


/*
Merge Two Sorted Lists:

merge two sorted lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
Example 2:
textInput: list1 = [], list2 = []
Output: []
Example 3:
textInput: list1 = [], list2 = [0]
Output: [0]
// https://leetcode.com/problems/merge-two-sorted-lists/
 */

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy

        var p1 = list1
        var p2 = list2

        while (p1 != null && p2 != null) {
            if (p1.`val` <= p2.`val`) {
                current.next = p1
                p1 = p1.next
            } else {
                current.next = p2
                p2 = p2.next
            }
            current = current.next!!
        }

        // Attach remaining nodes (if any)
        current.next = p1 ?: p2

        return dummy.next
    }

    // Definition for singly-linked list (for reference)
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
/* Alternative – Recursive version
    fun mergeTwoListsRecursive(list1: ListNode?, list2: ListNode?): ListNode? {
        // Base cases
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` <= list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }
 */

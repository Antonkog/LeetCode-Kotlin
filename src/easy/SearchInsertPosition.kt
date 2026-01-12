/*
Search Insert Position:
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
// https://leetcode.com/problems/search-insert-position/
*/
class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1          // target must be after mid
            } else {
                right = mid             // target is at mid or before mid
            }
        }

        return left
    }
}
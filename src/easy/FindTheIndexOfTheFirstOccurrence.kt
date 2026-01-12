/*

Find index of the first occurrence:

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
*/
class FindTheIndexOfTheFirstOccurrence {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (needle.length > haystack.length) return -1
        val needle = needle.toCharArray()
        val heystack = haystack.toCharArray()

        for(i in 0..heystack.size - needle.size) {
            var j = 0
            while(j < needle.size && heystack[i+j] == needle[j]) {
                j++
            }
            if(j == needle.size) {
                return i
            }
        }
        return -1
    }
}
/*
//Most Compact & Kotlin-idiomatic (using built-in function)
fun strStr(haystack: String, needle: String): Int =
    haystack.indexOf(needle)
*/
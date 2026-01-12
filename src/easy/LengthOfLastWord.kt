/*
Length of last word:
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

https://leetcode.com/problems/length-of-last-word/
*/

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var i = s.length - 1
        while (i >= 0 && s[i] == ' ') i--
        var len = 0
        while (i >= 0 && s[i] != ' ') {
            len++
            i--
        }
        return len
    }
}
/*

Longest Common Prefix:

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

https://leetcode.com/problems/longest-common-prefix/
*/

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        // Take first string as reference
        val first = strs[0]

        for (i in first.indices) {               // for each character position in the first string
            val char = first[i]                  // current character we are checking

            for (j in 1 until strs.size) {       // Check every string EXCEPT the first one
                if (i == strs[j].length || strs[j][i] != char) {
                    // Two reasons to stop and return the prefix found so far:
                    // 1. i == strs[j].length    → current string is shorter than position i
                    //                            → we reached the end of this string → no more characters
                    //
                    // 2. strs[j][i] != char     → characters at the same position are different
                    //                            → this is where the common prefix ends
                    //
                    // In both cases → common prefix ends **before** position i
                    return first.substring(0, i)         // return characters from index 0 to i-1
                }
            }
        }

        // If we get here, the whole first string is the common prefix
        return first
    }
}
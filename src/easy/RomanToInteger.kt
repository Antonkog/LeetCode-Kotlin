/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
*/

// RomanToInteger.kt
// https://leetcode.com/problems/roman-to-integer/

class RomanToInteger {
    fun romanToInt(s: String): Int {
        var result = 0
        var prev = 0

        // Right-to-left approach (often faster in practice)
        for (i in s.length - 1 downTo 0) {
            val current = when (s[i]) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }

            if (current < prev) {
                result -= current
            } else {
                result += current
            }

            prev = current
        }

        return result
    }
}

// Alternative left-to-right approach:
/*
class RomanToInteger {
    private val values = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
        'C' to 100, 'D' to 500, 'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var total = 0
        for (i in 0 until s.length - 1) {
            val current = values[s[i]]!!
            val next = values[s[i + 1]]!!
            total += if (current < next) -current else current
        }
        return total + values[s.last()]!!
    }
}
*/
/*
Valid Parentheses:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

// https://leetcode.com/problems/valid-parentheses/
 */

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = CharArray(s.length)     // fixed size array – no resizing
        var ptr = 0                         // manual pointer instead of object stack

        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack[ptr++] = char
                ')' -> if (ptr == 0 || stack[--ptr] != '(') return false
                ']' -> if (ptr == 0 || stack[--ptr] != '[') return false
                '}' -> if (ptr == 0 || stack[--ptr] != '{') return false
                else -> return false
            }
        }

        return ptr == 0
    }
}

/*
//Alternative, slower. (ArrayDeque / LinkedList style)

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (c in s) {
        when (c) {
            '(', '[', '{' -> stack.addLast(c)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
        }
    }

    return stack.isEmpty()
}
 */
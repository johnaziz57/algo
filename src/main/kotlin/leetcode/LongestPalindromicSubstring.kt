package leetcode

class LongestPalindromicSubstring {
    private var largestPalindrome = ""

    fun longestPalindrome(s: String): String {
        largestPalindrome = ""
        longestPalindrome(s, 0, s.length - 1, Array(s.length) { Array(s.length) { -1 } })
        return largestPalindrome
    }


    private fun longestPalindrome(s: String, i: Int, j: Int, cache: Array<Array<Int>>): Boolean {
        if (i > j || i >= s.length || j < 0) {
            return true
        }
        if (cache[i][j] != -1) {
            return cache[i][j] != 0
        }
        if (i == j && largestPalindrome.isEmpty()) {
            largestPalindrome = s.substring(i, j + 1)
            cache[i][j] = 1
            return true
        }


        val result = longestPalindrome(s, i + 1, j - 1, cache)
        if (result && s.elementAt(i) == s.elementAt(j)) {
            if (largestPalindrome.length < j - i + 1) {
                largestPalindrome = s.substring(i, j + 1)
            }
            cache[i][j] = 1
            return true
        }
        longestPalindrome(s, i + 1, j, cache)
        longestPalindrome(s, i, j - 1, cache)
        cache[i][j] = 0
        return false
    }
}

fun main(args: Array<String>) {
    val solution = LongestPalindromicSubstring()
    println(solution.longestPalindrome("babad"))
    println(solution.longestPalindrome("cbbd"))
    println(solution.longestPalindrome("abc"))
    println(solution.longestPalindrome("a"))
    println(solution.longestPalindrome("abbobba"))
    println(solution.longestPalindrome("12345667abbobba"))
    println(solution.longestPalindrome("xabbobbay"))
}
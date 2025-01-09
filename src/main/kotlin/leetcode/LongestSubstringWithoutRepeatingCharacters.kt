package leetcode

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var count = 0
        var maximumCount = 0
        var i = 0
        while (i < s.length) {
            val currentChar = s.elementAt(i)
            if (map.contains(currentChar)) {
                if (maximumCount < count) {
                    maximumCount = count
                }
                count = 0
                i = map[currentChar]?.plus(1) ?: 1
                map.clear()
            } else {
                count ++
                map[currentChar] = i
                i++
            }
        }
        if (maximumCount < count) {
            maximumCount = count
        }
        return maximumCount
    }
}

fun main(args: Array<String>) {
    val solution = LongestSubstringWithoutRepeatingCharacters()
    println(solution.lengthOfLongestSubstring("dvdf"))
    println(solution.lengthOfLongestSubstring("abcabcbb"))
    println(solution.lengthOfLongestSubstring("bbbbb"))
    println(solution.lengthOfLongestSubstring("pwwkew"))
    println(solution.lengthOfLongestSubstring("aaabcd"))
}
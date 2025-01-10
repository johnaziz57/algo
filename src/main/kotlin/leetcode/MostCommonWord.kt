package leetcode

import java.util.TreeMap

class MostCommonWord {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val bannedSet = banned.toHashSet()
        val map = mutableMapOf<String, Int>()

        paragraph.split("[ !?',;.]".toRegex()).forEach {
            val currentWord = it.lowercase()
            if (!bannedSet.contains(currentWord) && currentWord.isNotBlank()) {
                map[currentWord.lowercase()] = (map[currentWord.lowercase()] ?: 0) + 1
            }
        }
        return map.toList().maxByOrNull { it.second }!!.first
    }
}

fun main(args: Array<String>) {
    val solution = MostCommonWord()
    println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))

}
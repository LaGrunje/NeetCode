
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = nums.groupBy {it}.mapValues { it.value.size }
        val frequency = Array<MutableList<Int>>(nums.size) { mutableListOf() }
        for ((elem, freq) in frequencyMap) {
            frequency[freq-1].add(elem)
        }
        val result = mutableListOf<Int>()
        for (ind in frequency.size - 1 downTo 0) {
            if (result.size < k && frequency[ind].isNotEmpty()) {
                result.addAll(frequency[ind])
            }
        }
        return result.toIntArray()
    }
}

/*

 */
fun main() = println("Kotlin solution - top k frequent elements")
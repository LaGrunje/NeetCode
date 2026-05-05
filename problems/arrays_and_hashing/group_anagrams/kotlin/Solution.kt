class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val dictOfDicts: MutableMap<Map<Char, Int>, MutableList<String>> = mutableMapOf()
        for (str in strs) {
            val dict: Map<Char, Int> = str.groupingBy { it }.eachCount()
            if (dict in dictOfDicts) {
                dictOfDicts[dict]!!.add(str)
            } else {
                dictOfDicts[dict] = mutableListOf(str)
            }
        }
        return dictOfDicts.values.asSequence().map { it.toList() }.toList()
    }
}


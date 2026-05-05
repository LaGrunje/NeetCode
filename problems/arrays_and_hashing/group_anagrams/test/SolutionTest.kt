import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `return for empty string`() {
        assertEquals(listOf(listOf("")), solution.groupAnagrams(arrayOf("")))
    }

    @Test
    fun `return for solo string`() {
        assertEquals(listOf(listOf("x")), solution.groupAnagrams(arrayOf("x")))
    }

    @Test
    fun `return for set string`() {
        assertEquals(
            listOf(listOf("hat"), listOf("act", "cat"), listOf("stop", "pots", "tops")).map { it.toSet() }.toSet(),
            solution.groupAnagrams(arrayOf("act", "pots", "tops", "cat", "stop", "hat")).map { it.toSet() }.toSet()
        )
    }
}
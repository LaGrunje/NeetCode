import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class SolutionTest {
    private val solutionTest = Solution()

    @Test
    fun `return true with empty strings`() {
        assertTrue( solutionTest.isAnagram("", "") )
    }

    @Test
    fun `return true with anagram`() {
        assertTrue( solutionTest.isAnagram("racecar", "carrace") )
    }

    @Test
    fun `return true with non-anagram`() {
        assertFalse( solutionTest.isAnagram("jar", "jam") )
    }

    @Test
    fun `return true with different length`() {
        assertFalse( solutionTest.isAnagram("eee", "eeee") )
    }
}
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BruteForceTest {
    @Test
    fun test4x4Successfully() {
        val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0003.txt").getPuzzle()
        val bruteForceStrategy = BruteForce(puzzle)
        bruteForceStrategy.solve()

        assertEquals(puzzle.isComplete, true)
    }

    @Test
    fun test9x9Successfully() {
        val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0003.txt").getPuzzle()
        val bruteForceStrategy = BruteForce(puzzle)
        bruteForceStrategy.solve()

        assertEquals(puzzle.isComplete, true)
    }
}
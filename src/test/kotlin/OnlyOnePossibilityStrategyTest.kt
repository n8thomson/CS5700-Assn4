import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class OnlyOnePossibilityStrategyTest {

    @Nested
    inner class checkColumns {

        @Test
        fun test4x4Successful() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0003.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkColumns(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun test4x4Failure() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0004.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkColumns(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }

        @Test
        fun test9x9Successful() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0003.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkColumns(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun test9x9Failure() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0004.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkColumns(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }
    }


    @Nested
    inner class checkRows() {
        @Test
        fun test4x4Successful() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0003.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkRows(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun test4x4Failure() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0002.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkRows(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }

        @Test
        fun test9x9Successful() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0001.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkRows(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun test9x9Failure() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0002.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkRows(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }
    }

    @Nested
    inner class checkBlocks() {
        @Test
        fun testBlocks4x4Successfully() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0003.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkBlocks(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun testBlocks4x4Failed() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-4x4-0002.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkBlocks(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }

        @Test
        fun testBlocks9x9Successfully() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0003.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkBlocks(puzzle)

            assertEquals(puzzle.checkIfComplete(), true)
        }

        @Test
        fun testBlocks9x9Failed() {
            val puzzle = SudokuFileReader("SamplePuzzles/TestPuzzles/Test-9x9-0005.txt").getPuzzle()
            val strat = OnlyOnePossibilityStrategy(puzzle)
            strat.checkBlocks(puzzle)

            assertEquals(puzzle.checkIfComplete(), false)
        }
    }
}
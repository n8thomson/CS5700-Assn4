interface Command {
    fun execute(puzzle: SudokuPuzzle): SudokuPuzzle {return SudokuPuzzle(4, mutableListOf(), mutableListOf())
    }
}
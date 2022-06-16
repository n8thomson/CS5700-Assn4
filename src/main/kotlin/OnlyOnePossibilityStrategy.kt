import kotlin.math.sqrt

class OnlyOnePossibilityStrategy(var puz: SudokuPuzzle): Strategy() {

    override var puzzle = puz
    override fun technique() {
        TODO("Not yet implemented")
    }

    fun checkColumns(puzzle: SudokuPuzzle): SudokuPuzzle {
        val charsFound = mutableListOf<String>()
        val allChars = mutableListOf<String>()

        for (y in 0 until puzzle.size) {
            for (z in puzzle.chars) {
                allChars.add(z)
            }
            for (x in 0 until puzzle.size) {
                if (puzzle.grid[x][y] != "-") {
                    charsFound.add(puzzle.grid[x][y])
                }
            }

            if (charsFound.size + 1 == puzzle.chars.size) {

                for (char in charsFound) {
                    if (allChars.contains(char)) {
                        allChars.remove(char)
                    }
                }

                for(x in 0 until puzzle.size) {
                    if (puzzle.grid[x][y] == "-") {
                        puzzle.grid[x][y] = allChars[0]
                    }
                }
            }

            charsFound.clear()
            allChars.clear()
        }

        return puzzle
    }

    fun checkRows(puzzle: SudokuPuzzle): SudokuPuzzle {
        val charsFound = mutableListOf<String>()
        val allChars = mutableListOf<String>()

        for (y in 0 until puzzle.size) {
            for (z in puzzle.chars) {
                allChars.add(z)
            }
            for (x in 0 until puzzle.size) {
                if (puzzle.grid[y][x] != "-") {
                    charsFound.add(puzzle.grid[y][x])
                }
            }

            if (charsFound.size + 1 == puzzle.chars.size) {

                for (char in charsFound) {
                    if (allChars.contains(char)) {
                        allChars.remove(char)
                    }
                }

                for(x in 0 until puzzle.size) {
                    if (puzzle.grid[y][x] == "-") {
                        puzzle.grid[y][x] = allChars[0]
                    }
                }
            }
            charsFound.clear()
            allChars.clear()
        }

        return puzzle
    }

    fun checkBlockCommand(puzzle: SudokuPuzzle): SudokuPuzzle {
        val charsFound = mutableListOf<String>()
        val allChars = mutableListOf<String>()
        val specialNum = sqrt(puzzle.size.toDouble()).toInt()

        for (y in 0 until puzzle.size) {
            for (z in puzzle.chars) {
                allChars.add(z)
            }

            for (x in 0 until puzzle.size) {
                val x0 = (Math.floorDiv(x, specialNum)) * specialNum
                val y0 = (Math.floorDiv(y, specialNum)) * specialNum

                for (i in 0 until specialNum) {
                    for (j in 0 until specialNum) {
                        if (puzzle.grid[y0+ i][x0 + j] != "-") {
                            charsFound.add(puzzle.grid[y0+ i][x0 + j])

                            if (charsFound.size + 1 == puzzle.chars.size) {

                                for (char in charsFound) {
                                    if (allChars.contains(char)) {
                                        allChars.remove(char)
                                    }
                                }

                                for(i in 0 until puzzle.size) {
                                    if (puzzle.grid[i][y] == "-") {
                                        puzzle.grid[i][y] = allChars[0]
                                    }
                                }
                            }
                        }
                    }
                }
                charsFound.clear()
            }

            allChars.clear()
        }
        return puzzle
    }
}

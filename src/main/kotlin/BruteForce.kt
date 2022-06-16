import kotlin.math.sqrt

class BruteForce(var puzzle: SudokuPuzzle) {
    private val sizeNum = sqrt(puzzle.size.toDouble()).toInt()

   fun solve() {
        for (y in 0 until puzzle.size) {

            for (x in 0 until puzzle.size) {


                if (puzzle.grid[y][x] == "-") {
                    for (n in 1 until puzzle.size + 1) {
                        if (possible(y, x, n)) {
                            puzzle.grid[y][x] = puzzle.chars[n - 1]
                            solve()
                        }
                        puzzle.grid[y][x] = "-"
                    }

                    return

                }
            }
        }
        puzzle.toString()
        println()
        puzzle.isComplete = true
    }

    private fun possible(y: Int, x: Int, n: Int): Boolean {
        for (i in 0 until puzzle.size) {
            if (puzzle.grid[y][i] == n.toString()) {
                return false
            }
        }
        for (i in 0 until puzzle.size) {
            if (puzzle.grid[i][x] == n.toString()) {
                return false
            }
        }

        val x0 = (Math.floorDiv(x, sizeNum)) * sizeNum
        val y0 = (Math.floorDiv(y, sizeNum)) * sizeNum

        for (i in 0 until sizeNum) {
            for (j in 0 until sizeNum) {
                if (puzzle.grid[y0+ i][x0 + j] == puzzle.chars[n - 1].toString()) {
                    return false
                }
            }
        }
        return true
    }
}
class SudokuPuzzle(
    val size: Int = 0,
    val grid: MutableList<MutableList<String>>,

    val chars: MutableList<String>,
    var isComplete: Boolean = false
) {

    override fun toString(): String {
        grid.forEach {
            println(it)
        }

        return ""
    }

    fun checkIfComplete(): Boolean {
        for (x in grid) {
            for (y in x) {
                if (y == "-") {
                    return false
                }
            }
        }

        return true
    }
}
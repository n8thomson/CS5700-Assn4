import kotlin.math.sqrt

class SudokuPuzzleBuilder {
    private var size: Int = 0
    private val grid = mutableListOf<MutableList<String>>()
    private var symbols = mutableListOf<String>()

    fun setSize(value: Int): SudokuPuzzleBuilder {
        if (sqrt(size.toDouble()) % 1.0 != 0.0){
            throw IllegalArgumentException("Not a square size")
        }
        this.size = value
        return this
    }

    fun addRow(row: MutableList<String>): SudokuPuzzleBuilder {
        this.grid.add(row)
        return this
    }

    fun setSymbols(symbols: MutableList<String>) {
        this.symbols = symbols
    }

    fun build(): SudokuPuzzle {
        return SudokuPuzzle(size = this.size, grid = this.grid, this.symbols)
    }
}
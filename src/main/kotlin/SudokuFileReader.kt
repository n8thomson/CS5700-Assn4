import java.io.File

class SudokuFileReader(private val fileName: String) {


        private val file: File = File(fileName)
        private val lines = file.readLines()
        private val sudokuPuzzle = SudokuPuzzleBuilder()



        fun getPuzzle(): SudokuPuzzle {
            for (i in lines) {
                if (lines.indexOf(i) == 0) {
                        sudokuPuzzle.setSize(i.toInt())
                } else if (lines.indexOf(i) == 1) {
                    val list = i.split(" ")
                    sudokuPuzzle.setSymbols(list as MutableList<String>)
                } else {
                    val list = i.split(" ")
                    sudokuPuzzle.addRow(list as MutableList<String>)
                }
            }

            return sudokuPuzzle.build()
        }




}
# game-Sudoku
Game of Sudoku in Java

## How it works?

![Screenshot](/images/screenshot.bmp)

Numbers to that first square (green) are choosen with a single sampling algorithm. Initially we have an inclusive range of numbers from 1 to 9, indexed 0 to 8. The program chooses random index and inserts respective number into the first cell of the square. Used number is then
deleted from the set, which means now we have to choose random index from inclusive range 0 to 7. This algorithm repeats until the list of possible values is emptied filling consecutive cells. Single sampling ensures there won't be any repetitions in this square and we have
9! = 362880 possible layouts.

Remaining squares are filled with numbers from the first square in a following manner:
For every consecutive 'n' square we take the last value (blue) of the previous square and put it in the first cell of the square, then we take remaining 8 values (red) from the previous square and put them in empty cells (in unchanged order). This procedure repeats until the whole grid is filled.

Last step to be taken to complete the board is deleting some of the numbers the user will have to fill in. Those are randomly choosen 30 values. I am aware that there is a certain probability that this may make the game unsolvable and it is essential to check it beforehand. However, with just 30 deleted numbers it shouldn't happen often. This part is planned to be modified in due course as the possibility to change difficulty level will be added.

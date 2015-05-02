minesweeper
===========
Minesweeper.java
    The JavaFX application that will run the game
    Problems:
        Represent Cells in a grid
        Allow Cells to view other Cells to make decisions
        Initialize a random grid

Cell.java
    An abstract class that will represent a Cell in the grid
    Properties of all Cells:
        Can be flagged and unflagged
        Can be clicked if unflagged
        Can't be clicked if flagged

Types of Cells:
    Mine - Explodes when clicked
    Safe - Reveals hints when clicked

# Prompts:
---
Chat Gpt:
- Write the code for a game of minesweeper in java
- Extend this code and write it to display on java swing

I manually went through the Copilot Responses and picked the parts of the code that I wanted and where to place them. To get a good looking UI, I had to guide it.

Copilot
- how to close a jOptionPane in Swing
- write the code display board like it was a text minesweeper game
- a function that adds 1 to each value in the values array adjacent to a bomb. It will not add 1 to values that are out of array or already bombs
- Write a function that detects if someone hase won the game, and announce it
- write a function that lets you create flags for the code
- Add an instructions message before opening the game
- Allow the user to select how many mines they would like
- allow user to enter the number of mines and the size of the board
- create a heading above my game board
- Create code to reveal board on
- Color the buttons
- add a timer to the bottom of the screen as well as a total revealed

Below is the outline I made for this project before I started working on it.

# Planning
---
## Minesweeper Data Structure
---
**Initialize Board:**
- Create array 
	- `int[rows][columns] board`
- Operation:
	- Populate each indice with 0.
- Create array: 
	- `int[number_of_random_bombs][2] bombs`
- Operation:
	- Populate `bombs` with random integers contained in `rows` and `columns`
- Operation:
	- Set `-1`'s on each indice of `board` contained in `bombs`. 
- Operations:
	- Add 1 to the value of each valid adjacent index in `board` contained in `bombs`.
		- Valid:
			- row_pointer < rows && row_pointer >= 0
			- column_pointer < column && column_pointer >= 0
			- `board[row_pointer][column_pointer] != -1`


## Game Board:
---
`int Status`
- 0 = Hidden
- 1 = Revealed
- -1 = flagged

`int[rows][columns] display_board`

## Click On Reveal Board:
---
`int Mode`:
- 0 = Click
- 1 = Flag

`Click(x,y):`
- `if (display_status[x][y] == 0)`
	- `display_status[x][y] == 1`
		- This this reveals the square.
	- `Reveal(x,y)`
		- Activeates the reveal function.
- `if (display_status[x][y] == -1)`
	- `display_status[x][y] = 0`
		- Removes a flag
		

`Flag(x,y):`
- `if (display_status\[x]\[y] == -1)`
	- `display_status[x][y] = 0`
		- Removes Flag
- if `(display_status[x][y] = 0)`
	- `display_status[x][y] = -1`
		- Adds Flag

## UI
---
Using: Java swing

**Display:**
- Create a set of squares for `rows` and `columns` corresponding to the Display Board
	- If they are revealed, 
- Contents vary based on whether the 
**Display:**

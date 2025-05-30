🎮 Tic Tac Toe - Java Console Game
A simple command-line Tic Tac Toe game written in Java that supports:

🧑‍🤝‍🧑 2-player mode

🧠 Player vs Computer (random AI)

It showcases:
Java basics (arrays, conditionals, loops)
Input validation and exception handling
Modular functions and gameplay logic
Turn-based console output

🕹️ How to Play
Compile and Run:
javac TicTacToe.java
java TicTacToe

Menu Options:
1. Player Name: Customize names for Player 1 and Player 2
2. Start game (2 Players): Human vs Human
3. Play vs Computer: Human vs Random AI
4. Quit: Exit the game

Gameplay Instructions:

Use numbers 1 to 9 to place your move on the board.
Position layout:

 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9

First player uses 'X', second uses 'O'. The game detects wins (rows, columns, diagonals) and draws automatically.

🧠 Features
✅ Custom player names

✅ Random AI opponent

✅ Turn-based gameplay

✅ Input validation with helpful prompts

✅ Win/draw detection

✅ Board reset after each game


🛠️ Code Highlights
print() – Renders the board with a clean format
won() – Detects all possible win conditions
notVacant() – Prevents overwriting moves
getPlayerMove() – Handles and validates user input
ticTacToe() – Main game loop for both modes
main() – Menu-driven navigation

🚀 Future Improvements
🤖 Smarter AI using Minimax algorithm
🖼️ GUI version using Java Swing or JavaFX
🏆 Scoreboard to track multiple rounds

📁 File Structure
TicTacToe.java      // Main game source file
README.md           // Project info and instructions

📄 License
This project is open-source and free to use, learn from, or modify for your own educational projects.
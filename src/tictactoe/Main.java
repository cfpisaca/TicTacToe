package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] tBoard = new char[3][3]; // creates empty tBoard array

        System.out.println("---------"); // prints out empty tBoard array
        for (int i = 0; i < 3; i++) {
            String iBoard = "| ";
            for (int j = 0; j < 3; j++) {
                tBoard[i][j] = ' ';
                iBoard = iBoard + tBoard[i][j] + " ";
            }
            System.out.println(iBoard + "|");
        }
        System.out.println("---------");

        int gameFinished = 0; // checks if game is finished and ends while loop, which creates each turn
        int gameCounter = 1; // changes play for each turn
        char player = 'X';
        while (gameFinished == 0) {
            if (gameCounter % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }
            gameCounter = gameCounter + 1;
            int repeat = 0; // checks if inputs are: between 1 and 3, cell occupied, non-integer, and repeats accordingly
            while (repeat == 0) { // also finally stops repeating, replacing blank space with chosen coordinate
                if (scanner.hasNextInt()) {
                    int xCord = scanner.nextInt();
                    int yCord = scanner.nextInt();
                    if (xCord > 3 || xCord < 1 || yCord > 3 || yCord < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        if (tBoard[xCord - 1][yCord - 1] == ' ') {
                            tBoard[xCord - 1][yCord - 1] = player;
                            break;
                        } else {
                            System.out.print("This cell is occupied! Choose another one!");
                        }
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            }

            System.out.println("---------"); // prints new adjusted tBoard according to inputs
            for (int i = 0; i < 3; i++) {
                String iBoard = "| ";
                for (int j = 0; j < 3; j++) {
                    iBoard = iBoard + tBoard[i][j] + " ";
                }
                System.out.println(iBoard + "|");
            }
            System.out.println("---------");


            int xWins = 0; // empty variables to count wins for player X and O
            int oWins = 0;

            for (int i = 0; i < 3; i++) { // checks for horizontal wins
                String curr = String.valueOf(tBoard[i]);
                if (curr.equals("XXX")) {
                    xWins += 1;
                } else if (curr.equals("OOO")) {
                    oWins += 1;
                }
            }

            int v = 0;
            while (v < 3) {
                String curr = "";
                for (int i = 0; i < 3; i++) { // checks for vertical wins
                    curr = curr + tBoard[i][v];
                }
                if (curr.equals("XXX")) {
                    xWins += 1;
                } else if (curr.equals("OOO")) {
                    oWins += 1;
                }
                v++;
            }

            int r = 0; // checks from diagonal wins (from right side)
            String rDiagonal = "";
            while (r < 3) {
                rDiagonal = rDiagonal + tBoard[r][r];
                r++;
            }
            if (rDiagonal.equals("XXX")) {
                xWins += 1;
            } else if (rDiagonal.equals("OOO")) {
                oWins += 1;
            }

            int l = 0; // checks from diagonal wins (from left side)
            String lDiagonal = "";
            while (l < 3) {
                lDiagonal = lDiagonal + tBoard[l][Math.abs(l - 2)];
                l++;
            }
            if (lDiagonal.equals("XXX")) {
                xWins += 1;
            } else if (lDiagonal.equals("OOO")) {
                oWins += 1;
            }

            int emptyCells = 0; // calculates number of empty cells, x's & o's
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tBoard[i][j] == ' ') {
                        emptyCells += 1;
                    }
                }
            }

            if (((xWins == 0 && oWins == 0) && emptyCells == 0)) { // checks the outcome of the game
                System.out.println("Draw");
                gameFinished = gameFinished + 1;
            } else if (xWins > oWins) {
                System.out.println("X wins");
                gameFinished = gameFinished + 1;
            } else if (oWins > xWins) {
                System.out.println("O wins");
                gameFinished = gameFinished + 1;
            }
        }
    }
}



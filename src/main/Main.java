package main;

import java.io.IOException;
import java.util.Scanner;


import manager.Manager;
import player.Player;

public class Main {
    public static void main(String args[]) throws IOException {
        Manager game = new Manager();
        Scanner kb = new Scanner(System.in);

        // System.out.println("Press any key (ESC to quit):");

        Player winner = null;
        while (true){
            // print the board
            reprintBoard(game);
            // display who's turn it is
            System.out.println("Player " + (game.getTurnPlayer().getID()+1) + "\'s turn");

            // System.out.println("Enter position [char][number]: ");
            
            boolean valid = false;
            while (!valid){
                System.out.println("Enter position [char][number]: ");
                // System.out.flush();
                String s = kb.nextLine();
                if (s.length() != 2)
                    continue;
                char c = s.charAt(0);
                if (c != 'a' && c != 'b' && c != 'c'){
                    continue;
                }
                int y = c - 'a';
                char i = s.charAt(1);
                int x = Integer.parseInt(String.valueOf(i));
                if (x < 1 && x > 3)
                    continue;
                valid = true;
                game.endTurn(x-1, y);
            }
            reprintBoard(game);
            

            // Check Winner
            winner = game.checkWinner();
            if (winner != null){
                System.out.println("Player " + (winner.getID()+1) + " wins!");
                break;
                // print winner
                // ask to play again or quit
            }
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void reprintBoard(Manager game) {
        clearScreen();
        System.out.println(game.boardToString());
    }

}
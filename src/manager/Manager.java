package manager;

import board.Board;
import board.Board.Direction;
import board.Mark;
import player.Player;

public class Manager {
    private Player[] players;
    private Board board;
    private int turnPlayer;


    public Manager(){
        players = new Player[2];
        players[0] = new Player('O');
        players[1] = new Player('X');
        turnPlayer = 0;
        board = new Board();
    }

    public Player getTurnPlayer(){
        return players[turnPlayer];
    }

    public void noveHover(Direction direction){
        board.moveHover(direction);
    }

    public boolean endTurn(int x, int y){
        boolean played = board.setMark(x, y, getTurnPlayer());
        return validateEndTurn(played);
    }

    public boolean endTurn(){
        boolean played = board.mark(getTurnPlayer());
        return validateEndTurn(played);
    }

    private boolean validateEndTurn(boolean played){
        if (played){
            turnPlayer = (++turnPlayer) % 2;
            return true;
        }
        return false;
    }

    public String boardToString(){
        return board.toString();
    }

    // check win

    public Player checkWinner(){
        int sum = 0;
        for (Player player : players){
            // Rows
            for (int y = 0; y < board.getSize(); ++y){
                sum = 0;
                for (int x = 0; y < board.getSize(); ++y){
                    if (board.checkMark(x, y, player))
                        ++sum;
                }
                if (sum == board.getSize())
                    return player;
            }

            // Columns
            for (int x = 0; x < board.getSize(); ++x){
                sum = 0;
                for (int y = 0; y < board.getSize(); ++y){
                    if (board.checkMark(x, y, player))
                        ++sum;
                }
                if (sum == board.getSize())
                    return player;
            }

            // BackSlash (\) Diagonal
            sum = 0;
            for (int i = 0; i < board.getSize(); ++i){
                if (board.checkMark(i, i, player))
                    ++sum;
                if (sum == board.getSize())
                    return player;
            }

            // ForwardSlash (/) Diagonal
            sum = 0;
            for (int i = 0; i < board.getSize(); ++i){
                if (board.checkMark(i, board.getSize()-i, player))
                    ++sum;
                if (sum == board.getSize())
                    return player;
            }
        }
        return null;
    }
}

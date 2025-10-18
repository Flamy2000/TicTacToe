package board;

import player.Player;

public class Mark {
    private final Player player;

    public Mark(Player player){
        this.player = player;
    }

    public char getPlayerChar(){
        return player.getPlayerChar();
    }

    @Override
    public String toString(){
        return "" + player.getPlayerChar();
    }
}

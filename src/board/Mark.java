package board;

import player.Player;

public class Mark {
    private final Player player;

    public Mark(Player player){
        this.player = player;
    }

    public char GetPlayerChar(){
        return player.GetPlayerChar();
    }

    @Override
    public String toString(){
        return "" + player.GetPlayerChar();
    }
}

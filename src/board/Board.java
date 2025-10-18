package board;

import player.Player;

public class Board {
    private int size;
    private Mark[][] marks;
    private int hoverX = 0;
    private int hoverY = 0;

    public Board(){
        size = 3;
        marks = new Mark[size][size];
    }

    public boolean Mark(Player player){
        return SetMark(hoverX, hoverY, player);
    }

    private boolean SetMark(int x, int y, Player player){
        if (marks[x][y] != null)
            return false;
        
        marks[x][y] = new Mark(player);
        return true;
    }

    public void SetHover(int x, int y){
        this.hoverX = x;
        this.hoverY = y;
    }

    public Mark[][] GetBoard(){
        return marks;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size; ++y){
            for (int x = 0; x < size; ++x){
                boolean isHover = x == hoverX && y == hoverY;
                sb.append(isHover ? "[" : " ");

                sb.append(marks[x][y]==null ? " " : marks[x][y]);

                sb.append(isHover ? "]" : " ");

                if (x < size-1)
                    sb.append("|");
            }

            sb.append("\n");

            if (y >= size-1 )
                continue;
            
            for (int x = 0; x < size; ++x){
                sb.append("---");

                if (x < size-1)
                    sb.append("+");
            }
        }
        return sb.toString();
    }
}

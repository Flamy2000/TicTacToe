package board;

import player.Player;

public class Board {
    private int size;
    private Mark[][] marks;

    public Board(){
        size = 3;
        marks = new Mark[size][size];
    }

    public boolean setMark(int x, int y, Player player){
        if (marks[x][y] != null)
            return false;
        
        marks[x][y] = new Mark(player);
        return true;
    }

    public int getSize(){
        return size;
    }

    public boolean checkMark(int x, int y, Player player){
        if (marks[x][y] == null)
            return false;

        return marks[x][y].getPlayerID() == player.getID();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        for (int x = 0; x < size; ++x){
            sb.append(" ");
            sb.append(x+1);
            sb.append("  ");
        }
        sb.append("\n");


        for (int y = 0; y < size; ++y){
            // sb.append(" ");
            sb.append((char)('a'+y));
            for (int x = 0; x < size; ++x){
                sb.append(" ");
                sb.append(marks[x][y]==null ? " " : marks[x][y]);
                sb.append(" ");

                if (x < size-1)
                    sb.append("|");
            }

            sb.append("\n ");

            if (y >= size-1 )
                continue;
            
            for (int x = 0; x < size; ++x){
                sb.append("---");

                if (x < size-1)
                    sb.append("+");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}

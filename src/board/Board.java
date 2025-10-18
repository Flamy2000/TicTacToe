package board;

import player.Player;

public class Board {
    private int size;
    private Mark[][] marks;
    private int hoverX = 0;
    private int hoverY = 0;

    public enum Direction {Up, Down, Left, Right}

    public Board(){
        size = 3;
        marks = new Mark[size][size];
    }

    public boolean mark(Player player){
        return setMark(hoverX, hoverY, player);
    }

    public boolean setMark(int x, int y, Player player){
        if (marks[x][y] != null)
            return false;
        
        marks[x][y] = new Mark(player);
        return true;
    }

    public void setHover(int x, int y){
        this.hoverX = x;
        this.hoverY = y;
    }

    public void moveHover(Direction direction){
        if (direction == Direction.Up)
            this.hoverY--;
        if (direction == Direction.Down)
            this.hoverY++;
        this.hoverY = (hoverY + size) % size;

        if (direction == Direction.Left)
            this.hoverX--;
        if (direction == Direction.Right)
            this.hoverX++;
        this.hoverX = (hoverX + size) % size;
    }

    public Mark[][] getBoard(){
        return marks;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size; ++y){
            for (int x = 0; x < size; ++x){
                boolean isHover = (x == hoverX) && (y == hoverY);
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

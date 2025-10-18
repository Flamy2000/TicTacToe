package player;

public class Player {
    private int turnID;
    private int score;
    private char playerChar;

    private static int nextTurnID = 0;

    public Player(char playerChar){
        this.playerChar = playerChar;
        this.turnID = nextTurnID++;
        score = 0;
    }

    public void AddPoint(){
        ++score;
    }

    public char GetPlayerChar(){
        return this.playerChar;
    }

    @Override
    public String toString(){
        return "Player " + turnID + ": " + score;
    }
}

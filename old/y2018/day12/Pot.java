package y2018.day12;

public class Pot implements Comparable<Pot>{
    final int number;
    private boolean planted;
    private boolean newState;

    public Pot(int number, char planted){
        this.number = number;
        switch (planted) {
            case '.':
                this.planted = false;
                break;
            case '#':
                this.planted = true;
                break;
        }
    }

    public Pot(int number, boolean planted) {
        this.number = number;
        this.planted = planted;
    }

    public void setPlanted(boolean planted){
        newState= planted;
    }

    public boolean isPlanted(){
        return planted;
    }

    public void tick(){
        planted=newState;
    }


    @Override
    public int compareTo(Pot pot) {
        return Integer.compare(this.number, pot.number);
    }
}

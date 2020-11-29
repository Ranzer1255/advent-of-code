package y2018.day12;

public class Pot implements Comparable<Pot>{
    final int number;
    private boolean planted;
    private boolean newState;

    public Pot(int number, char state){
        this.number = number;
        switch (state) {
            case '.':
                this.planted = false;
                break;
            case '#':
                this.planted = true;
                break;
        }
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

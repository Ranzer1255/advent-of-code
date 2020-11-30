package y2018.day6;

public class Loc {
    int x,y;

    public Loc(int x, int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Loc){
            return (this.x==((Loc) obj).x&&this.y==((Loc) obj).y);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", x,y);
    }
}

package y2018.day7;

public class Worker {

    int time = 0;
    Step step;
    boolean done = false;


    public void tick(){
        if(step==null) return;
        if (--time==0) done = true; //? this may need to be time--
    }

    public void setJob(Step s){
        time = s.durration;
        step=s;
        done = false;
    }

    boolean working(){
        return time>0;
    }

    char workingOn(){
        if (working()) return step.label;
        return '.';
    }

    boolean isDone(){
        return done;
    }
}

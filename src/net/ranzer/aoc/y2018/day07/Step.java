package net.ranzer.aoc.y2018.day07;

import java.util.ArrayList;
import java.util.List;

public class Step implements Comparable<Step> {

    final char label;
    List<Step> prereqs;
    private List<Step> dependents;
    final int durration;

    private boolean done = false;

    public Step(char label){
        this.label = label;
        prereqs = new ArrayList<>();
        dependents = new ArrayList<>();
        durration = (label - 64) + 60;
    }

    @Override
    public int compareTo(Step step) {
        return Character.compare(this.label, step.label);
    }

    void addPrereq(Step step) {
        prereqs.add(step);
    }

    boolean ready(){

        if(prereqs.isEmpty()) return true;

        for (Step s : prereqs) {
            if (!s.done) return false;
        }

        return true;
    }

    char use(){
        done=true;
        return label;
    }

    public List<Step> getDependents() {
        return dependents;
    }

    public void addDependent(Step step) {
        dependents.add(step);
    }
}

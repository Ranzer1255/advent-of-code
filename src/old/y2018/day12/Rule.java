package y2018.day12;

import java.util.Arrays;

public class Rule {

    boolean[] pattern = new boolean[5];
    boolean result;

    public Rule(String pattern, char result){
        for (int i = 0; i < pattern.length(); i++) {
            switch (pattern.charAt(i)) {
                case '.':
                    this.pattern[i]=false;
                    break;
                case '#':
                    this.pattern[i]=true;
                    break;
            }
        }

        this.result = result == '#';
    }


    public boolean applies(Pot l2, Pot l1, Pot c, Pot r1, Pot r2) {

        boolean[] sample = new boolean[5];
        if (l2==null){
            sample[0]=false;
        } else {
            sample[0]=l2.isPlanted();
        }
        if (l1==null){
            sample[1]=false;
        } else {
            sample[1]=l1.isPlanted();
        }
        if (r1==null){
            sample[3]=false;
        } else {
            sample[3]=r1.isPlanted();
        }
        if (r2==null){
            sample[4]=false;
        } else {
            sample[4]=r2.isPlanted();
        }
        sample[2]=c.isPlanted();

        return Arrays.equals(sample,pattern);
    }

    public boolean apply(){
        return result;
    }

}

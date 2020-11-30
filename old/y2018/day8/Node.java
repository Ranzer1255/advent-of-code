package y2018.day8;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> childNodes;
    private int[] metadata;

    public Node(int children, int metadata, List<Integer> inputStream){
        childNodes = new ArrayList<>(children);

        for (int i = 0; i < children; i++) {
            childNodes.add(new Node(inputStream.remove(0),inputStream.remove(0),inputStream));
        }

        this.metadata = new int[metadata];
        for (int i = 0; i < this.metadata.length; i++) {
            this.metadata[i] = inputStream.remove(0);
        }
    }

    public int metaSum(){
        int rtn = 0;

        for (int i = 0; i < metadata.length; i++) {
            rtn += metadata[i];
        }

        for (Node n : childNodes) {
            rtn += n.metaSum();
        }

        return rtn;
    }

    public int value(){
        int rtn =0;

        if(childNodes.isEmpty()){
            return metaSum();//TODO shouldn't hurt but be wary
        }

        for (int i = 0; i < metadata.length; i++) {
            if (metadata[i]==0 || metadata[i]>childNodes.size()) continue;
            rtn+=childNodes.get(metadata[i]-1).value();
        }

        return rtn;
    }
}

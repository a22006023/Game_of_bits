package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SegmentationFault extends Abyss{

    public SegmentationFault(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        return "SegmentationFault";
    }
}

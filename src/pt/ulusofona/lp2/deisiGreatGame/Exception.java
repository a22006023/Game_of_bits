package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Exception extends Abyss{

    public Exception(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        programmer.movePlayer(-2,200);
        movePlayerAbyss(boardMap,programmer);
        return "Exception";
    }
}


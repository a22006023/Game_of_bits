package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Logic extends Abyss{

    public Logic(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap){
        int positions = -(dado/2);
        programmer.movePlayer(positions, 200);
        movePlayerAbyss(boardMap,programmer);
        return "Logic";
    }
}

package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Logic extends Abyss{

    public Logic(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap){
        if (!TeachersHelp.class.isAssignableFrom(programmer.getTools().getClass()) &&
                !UnitTests.class.isAssignableFrom(programmer.getTools().getClass())) {
            int positions = -(dado/2);
            programmer.movePlayer(positions, 200);
            movePlayerAbyss(boardMap,programmer);
            return "Logic";
        }
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Erro de Lógica") || tool.getTitle().equals("Ajuda Do Professor")) {
                programmer.removeTool(tool);
            }
        }
        return "safaste-te";
    }
}

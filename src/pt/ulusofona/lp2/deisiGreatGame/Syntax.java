package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class Syntax extends Abyss{

    public Syntax(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        if (!TeachersHelp.class.isAssignableFrom(programmer.getTools().getClass()) &&
                !Ide.class.isAssignableFrom(programmer.getTools().getClass())) {
            programmer.movePlayer(-1,200);
            movePlayerAbyss(boardMap,programmer);
            return "Syntax";
        }
        for (Tool tool : programmer.getTools()) {
                if (tool.getTitle().equals("Tratamento de Excepções") || tool.getTitle().equals("IDE")) {
                programmer.removeTool(tool);
            }
        }
        return "safaste-te";
    }
}

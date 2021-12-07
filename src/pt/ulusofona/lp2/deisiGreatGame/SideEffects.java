package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SideEffects extends Abyss{

    public SideEffects(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        if (Functional.class.isAssignableFrom(programmer.getTools().getClass())) {
            for (Tool tool : programmer.getTools()) {
                if (tool.getTitle().equals("Functional")) {
                    programmer.removeTool(tool);
                }
            }
            return "safaste-te";
        }
        programmer.setPos(programmer.getPosAnteriorAnterior());
        movePlayerAbyss(boardMap,programmer);
        return "SideEffects";
    }
}

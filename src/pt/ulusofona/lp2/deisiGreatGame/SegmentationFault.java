package pt.ulusofona.lp2.deisiGreatGame;

import java.util.TreeMap;

public class SegmentationFault extends Abyss{

    public SegmentationFault(int id, int pos) {
        super(id, pos);
    }

    @Override
    public String react(Programmer programmer, int dado, TreeMap<Integer,Square> boardMap) {
        if (!Catch.class.isAssignableFrom(programmer.getTools().getClass())) { // verificar se existem dois jogadores nesta casa
            programmer.movePlayer(-3,200);
            movePlayerAbyss(boardMap,programmer);
            return "SegmentationFault";
        }
        for (Tool tool : programmer.getTools()) {
            if (tool.getTitle().equals("Tratamento de Excepções")) {
                programmer.removeTool(tool);
            }
        }
        return "safaste-te";
    }
}

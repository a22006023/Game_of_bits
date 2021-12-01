package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Square {
    List<Programmer> programmers = new ArrayList<>();
    int id;
    String title;
    int pos;

    public Square(int id,int pos){
        this.id = id;
        this.pos = pos;
    }

    public int getId(){
        return id;
    }

    public int getPos(){
        return pos;
    }

    public String getTitle(){
        return title;
    }

    public Square getAbyssOrTool(int numero){
        if(numero == 0){
            return new Syntax(id,pos);
        }else if(numero == 1){
            return new Logic(id,pos);
        }
        else return null;
    }

}

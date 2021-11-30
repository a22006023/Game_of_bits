package pt.ulusofona.lp2.deisiGreatGame;

public class Abyss {
    int id;
    String title;
    int pos;

    public Abyss (int id, int pos) {
        this.id = id;
        this.pos = pos;
        switch (id) {
            case 0 -> title = "Erro de sintaxe";
            case 1 -> title = "Erro de lógica";
            case 2 -> title = "Exception";
            case 3 -> title = "File Not Found Exception";
            case 4 -> title = "Crash (aka Rebentanço)";
            case 5 -> title = "Duplicated Code";
            case 6 -> title = "Efeitos secundários";
            case 7 -> title = "Blue Screen of Death";
            case 8 -> title = "Ciclo infinito";
            case 9 -> title = "Segmentation Fault";
            default -> title = "";
        }
    }

    public void getAbyss(){
        switch(id){
            case 0 -> abyssFunction0();
            case 1 -> abyssFunction1();
            case 2 -> abyssFunction2();
            case 3 -> abyssFunction3();
            case 4 -> abyssFunction4();
            case 5 -> abyssFunction5();
            case 6 -> abyssFunction6();
            case 7 -> abyssFunction7();
            case 8 -> abyssFunction8();
            case 9 -> abyssFunction9();
        }
    }

    public void abyssFunction9() {
    }

    public void abyssFunction8() {
    }

    public void abyssFunction7() {
    }

    public void abyssFunction6() {
    }

    public void abyssFunction5() {
    }

    public void abyssFunction4() {
    }

    public void abyssFunction3() {
    }

    public void abyssFunction2() {
    }

    public void abyssFunction1() {
    }

    public void abyssFunction0() {
    }


    public int getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public String getTitle(){
        return title;
    }
}

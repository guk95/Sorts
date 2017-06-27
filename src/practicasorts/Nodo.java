package practicasorts;

public class Nodo {

    private Nodo sig;
    private Nodo ant;
    private int dato;

    public Nodo(int dato) {
        this.sig = null;
        this.ant = null;
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

}

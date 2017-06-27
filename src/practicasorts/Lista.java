package practicasorts;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class Lista {

    private int size;
    private Nodo cabeza;

    public Lista() {
        this.size = 0;
        this.cabeza = null;

    }

    public boolean isEmpty() {

        return cabeza == null;
    }

    public boolean add(int dato) {

        Nodo nuevo = new Nodo(dato);
        int cont = 0;
        if (isEmpty()) {
            cabeza = nuevo;

        } else {
            Nodo aux = cabeza;
            while (cont < size - 1) {
                aux = aux.getSig();
                cont++;

            }

            nuevo.setAnt(aux);
            aux.setSig(nuevo);

        }
        size++;
        return true;
    }

    public boolean bubbleSort() {

        int cont = 0;

        while (cont < size) {
            Nodo aux = cabeza;
            Nodo aux2 = cabeza.getSig();
            int cont2 = 0;

            while (cont2 < size - 1) {

                if (aux.getDato() > aux2.getDato()) {
                    Nodo temp = aux;
                    Nodo ultimo = cabeza;
                    int cont3 = 0;
                    while (cont3 < size - 1) {
                        ultimo = ultimo.getSig();
                        cont3++;
                    }

                    if (aux == cabeza) {
                        aux2.getSig().setAnt(aux);
                        aux.setSig(aux2.getSig());
                        aux.setAnt(aux2);
                        aux2.setSig(aux);
                        aux2.setAnt(null);

                        cabeza = aux2;
                        aux = temp;
                        aux2 = temp.getSig();

                    } else if (aux2 == ultimo) {

                        aux.getAnt().setSig(aux2);
                        aux2.setAnt(aux.getAnt());
                        aux2.setSig(aux);
                        aux.setSig(null);
                        aux.setAnt(aux2);
                        ultimo = aux;
                        aux = temp;
                        aux2 = temp.getSig();
                        aux2 = temp;
                        aux = temp.getSig();

                    } else {
                        aux.getAnt().setSig(aux2);
                        aux2.getSig().setAnt(aux);
                        aux2.setAnt(aux.getAnt());
                        aux.setSig(aux2.getSig());
                        aux2.setSig(aux);
                        aux.setAnt(aux2);
                        aux2 = temp;
                        aux = aux2;
                        aux2 = temp;
                        aux = temp.getSig();

                    }

                } else {
                    aux = aux.getSig();
                    aux2 = aux2.getSig();

                }

                cont2++;
            }

            cont++;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Nodo aux = cabeza;
        int cont = 0;

        while (cont < size) {
            builder.append(" ");
            builder.append(aux.getDato());
            builder.append(System.getProperty("line.separator"));

            ++cont;
            aux = aux.getSig();
        }

        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

}

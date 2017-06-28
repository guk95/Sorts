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

    public Nodo getNodo(int index) {

        Nodo aux = cabeza;

        if (index > size || index < 0) {

            throw new IndexOutOfBoundsException("Ud es un animal");

        } else if (index == 0) {
            aux = cabeza;

        } else if (index == size - 1) {

            Nodo ultimo = cabeza;
            int cont2 = 0;
            while (cont2 < size - 1) {
                ultimo = ultimo.getSig();

                cont2++;
            }
            aux = ultimo;

        } else {
            int cont3 = 0;
            while (cont3 < index) {
                aux = aux.getSig();
                cont3++;

            }

        }

        return aux;
    }

    public Nodo pivote() {

        Nodo ultimo = cabeza;
        int cont = 0;
        while (cont < size - 1) {
            ultimo = ultimo.getSig();
            cont++;
        }
        Nodo delmedio = cabeza;
        int cont2 = 0;
        while (cont2 < Math.round(size / 2)) {
            delmedio = delmedio.getSig();
            cont2++;
        }

        Nodo pivote = delmedio;

        if (cabeza.getDato() < delmedio.getDato() && delmedio.getDato() < ultimo.getDato()) {
            pivote = delmedio;

        } else if (delmedio.getDato() < cabeza.getDato() && ultimo.getDato() > cabeza.getDato()) {
            pivote = cabeza;

        } else if (ultimo.getDato() < delmedio.getDato() && cabeza.getDato() < ultimo.getDato()) {

            pivote = ultimo;

        } else {

            pivote = delmedio;

        }
        return pivote;
    }

    public boolean quickSort() {

        int cont = 0;
        Nodo pivote = pivote();

        while (cont < size) {

            Nodo aux = cabeza;

            if (aux.getDato() > pivote.getDato()) {

                if (aux == cabeza) {
                    Nodo temp = cabeza.getSig();
                    pivote.getSig().setAnt(cabeza);
                    cabeza.setSig(pivote.getSig());
                    cabeza.setAnt(pivote);
                    pivote.setSig(cabeza);
                    cabeza = temp;
                    cabeza.setAnt(null);

                } else {

                    aux.getAnt().setSig(pivote);
                    pivote.getSig().setAnt(aux);
                    pivote.setAnt(aux.getAnt());
                    aux.setSig(pivote.getSig());
                    pivote.setSig(aux);
                    aux.setAnt(pivote);

                }

            } else {

            }

            cont++;

        }

        return true;
    }
    //                } else if (aux == ultimo) {
//                    pivote.getAnt().setSig(aux);
//                    aux.setAnt(pivote.getAnt());
//                    aux.setSig(pivote);
//                    pivote.setAnt(aux);
//                    ultimo = pivote;
//                    ultimo.setSig(null);

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

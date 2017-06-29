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

    public Nodo pivote(Lista lista) {

        Nodo ultimo = cabeza;
        int cont = 0;
        while (cont < lista.size - 1) {
            ultimo = ultimo.getSig();
            cont++;
        }
        Nodo delmedio = cabeza;
        int cont2 = 0;
        while (cont2 < Math.round(lista.size / 2)) {
            delmedio = delmedio.getSig();
            cont2++;
        }

        Nodo pivote;
        if (lista.size == 1) {
            pivote = lista.cabeza;

        } else if (cabeza.getDato() < delmedio.getDato() && delmedio.getDato() < ultimo.getDato()) {
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

    public boolean quickSort(Lista lista) {

        int cont = 0;

        Lista izquierda = new Lista();
        Lista derecha = new Lista();
        Lista nueva = new Lista();
        Nodo aux = lista.getCabeza();
        Nodo pivote = pivote(lista);

        while (cont < lista.size) {

            if (lista.size < 2) {
                nueva.add(aux.getDato());
                break;

            } else {
                if (aux.getDato() > pivote.getDato()) {
                    derecha.add(aux.getDato());

                } else {
                    izquierda.add(aux.getDato());

                }

                aux = aux.getSig();
                cont++;

            }

        }

        System.out.println(izquierda.toString());
        System.out.println(derecha.toString());
        System.out.println(nueva.toString());

        return true;
    }

    public boolean quickSort2(Lista lista) {
        Nodo aux = cabeza;
        Nodo ultimo = cabeza;
        int cont = 0;
        while (cont < lista.size - 1) {
            ultimo = ultimo.getSig();
            cont++;
        }
        Nodo aux2 = ultimo;
        Nodo pivote = pivote(lista);

        int cont2 = 0;
        while (cont2 < size/2+1) {

            Nodo izquierda = aux.getSig();
            Nodo derecha = aux2.getAnt();
            if (aux.getDato() > pivote.getDato()) {
                if (aux2.getDato() <= pivote.getDato()) {
                    if (aux == cabeza) {
                        if (aux2 == ultimo) {
                            cabeza.getSig().setAnt(ultimo);
                            cabeza.setAnt(ultimo.getAnt());
                            ultimo.getAnt().setSig(cabeza);
                            ultimo.setSig(izquierda);
                            ultimo = cabeza;
                            cabeza = izquierda.getAnt();
                            cabeza.setAnt(null);
                            ultimo.setSig(null);

                        } else {
                            Nodo temp3 = aux2.getSig();
                            aux2.getSig().setAnt(aux);
                            aux.getSig().setAnt(aux2);
                            aux2.getAnt().setSig(aux);
                            aux2.setSig(aux.getSig());
                            aux.setSig(temp3);
                            aux.setAnt(aux2.getAnt());

                            cabeza = aux2;
                            cabeza.setAnt(null);

                        }

                        aux = izquierda;
                        aux2 = derecha;

                    } else {
                        aux2.getSig().setAnt(aux);
                        aux.getSig().setAnt(aux2);
                        aux.getAnt().setSig(aux2);
                        aux2.setAnt(aux.getAnt());
                        aux.setAnt(derecha);
                        aux.setSig(aux2.getSig());
                        aux2.setSig(izquierda);
                        derecha.setSig(aux);
                        aux = izquierda;
                        aux2 = derecha;

                    }

                } else {

                    aux2 = aux2.getAnt();
                }

            } else {
                aux = aux.getSig();

            }

            cont2++;
        }

//        System.out.println(aux.getDato());
        System.out.println("este es el pivote: "+pivote.getDato());
//        System.out.println(ultimo.getDato());
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

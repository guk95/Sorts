package practicasorts;

public class PracticaSorts {

    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.add(4);
        lista.add(368);
        lista.add(2);
        lista.add(187);
        System.out.println(lista.toString());
        lista.bubbleSort();
        System.out.println(lista.toString());

    }

}

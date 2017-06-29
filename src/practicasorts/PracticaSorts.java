package practicasorts;

public class PracticaSorts {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.add(9);
        lista.add(8);
        lista.add(7);
        lista.add(6);
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);

        System.out.println(lista.toString());

        lista.quickSort2(lista);
        System.out.println(lista.toString());

    }

}

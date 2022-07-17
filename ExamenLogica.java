import java.util.Arrays;

public class ExamenLogica {
    public String[] lista;

    public Examen1() {
        this.lista = new String[0];
    }

    public Examen1(int length) {
        this.lista = new String[length];
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < this.lista.length; i++) {
            resultado += this.lista[i] + " | ";
        }
        return resultado;
    }

    public int count(String texto) {
        int resultado = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == texto) {
                resultado++;
            }
        }
        return resultado;
    }


    public boolean add (String texto) {
        Examen1 lista2 = new Examen1(this.lista.length + 1);
        for (int i = 0; i < this.lista.length; i++) {
            lista2.lista[i] = this.lista[i];
        }
        lista2.lista[this.lista.length] = texto;
        this.lista = lista2.lista;

        return true;
    }

    public boolean add (String texto, int position) {
        boolean resultado;
        Examen1 lista2 = new Examen1(this.lista.length + 1);
        if (lista2.lista.length > position && position >= 0) {
            resultado = true;
            for (int i = 0; i < position; i++) {
                    lista2.lista[i] = this.lista[i];
            }
            lista2.lista[position] = texto;

            for (int j = position; j < this.lista.length ; j++) {
                lista2.lista[j + 1] = this.lista[j];
            }
            this.lista = lista2.lista;
        } else {
            resultado = false;
        }
        return resultado;
    }

    public boolean delete (int position) {
        boolean resultado;
        if (this.lista.length > position && position >= 0) {
            resultado = true;
            Examen1 lista2 = new Examen1(this.lista.length - 1);
            for (int i = 0; i < position; i++) {
                lista2.lista[i] = this.lista[i];
            }
            for (int i = position; i < this.lista.length - 1; i++) {
                lista2.lista[i] = this.lista[i + 1];
            }
            this.lista = lista2.lista;
        } else {
            resultado = false;
        }
        return resultado;
    }


    public int remove (String texto) {
        int contador = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == texto) {
                this.delete(i);
                contador++;
            }
        }
        return contador;
    }

    public boolean invert() {
        boolean devuelve;
        if (this.lista.length == 0) {
            devuelve = false;
        } else {
            devuelve = true;
            Examen1 lista2 = new Examen1(this.lista.length);
            int contadorInverso = this.lista.length -1;
            for (int i = 0; i < lista.length; i++) {
                lista2.lista[i] = this.lista[contadorInverso];
                contadorInverso--;
            }
            this.lista = lista2.lista;
        }
        return devuelve;
    }


    public Examen1 subLista (int offset) {
        Examen1 lista2 = new Examen1();
        if (offset < this.lista.length) {
            Examen1 lista3 = new Examen1(offset + 1);
            lista2 = lista3;
            for (int i = 0; i < offset + 1; i++) {
                lista2.lista[i] = this.lista[i];
            }
        }
        return lista2;
    }


    public Examen1 subLista (int index, int offset) {
        Examen1 lista2 = new Examen1();
        if (index + offset < this.lista.length) {
            Examen1 lista3 = new Examen1(offset + 1);
            lista2 = lista3;
            int contador = 0;
            for (int i = index; i < index + offset + 1; i++) {
                lista2.lista[contador] = this.lista[i];
                contador++;
            }
        }
        return lista2;
    }




    public static void main(String[] args) {
        Examen1 lista = new Examen1();
        lista.add("Marcos");
        lista.add("Alba");
        lista.add("Marcos");
        lista.add("Maria");
        lista.add("Marcos");
        System.out.println(lista.add("Pepe",3));
        System.out.println(lista.toString());
        //System.out.println(lista.delete(1));
        System.out.println(lista.toString());
        System.out.println(lista.count("Marcos"));
        //System.out.println(lista.remove("Marcos"));
        System.out.println(lista.toString());
        System.out.println(lista.toString());
        //Lista lista2 = lista.subLista(2);
        //System.out.println(lista2);
        Examen1 lista2 = lista.subLista(2);
        System.out.println(lista2);
        Examen1 lista3 = lista.subLista(3,1);
        System.out.println(lista3);
        System.out.println(lista.invert());
        System.out.println(lista.toString());
    }
}

package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> resultado = new HashSet<>();
        Integer siguiente;
        Set<Integer> listarecorrer = new HashSet<>();
        Iterator<Integer> recorrer;
        while (it.hasNext()) {
            siguiente = it.next();
            recorrer = listarecorrer.iterator();
            if (siguiente != 0) {
                if (!(recorrer.hasNext())) {
                    listarecorrer.add(siguiente);
                }
                else {
                    while (recorrer.hasNext()) {
                        if ((siguiente % recorrer.next()) == 0) {
                            resultado.add(siguiente);
                        } else {
                            listarecorrer.add(siguiente);
                        }
                    }
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Iterator<Integer> cuadradosit = cuadrados.iterator();
        Set<Integer> cuadradosre = new HashSet<>();
        Set<Integer> noCuadradosre = new HashSet<>();
        Integer siguientec;
        Integer siguientecn;
        while (cuadradosit.hasNext()) {
            siguientec = cuadradosit.next();
            Iterator<Integer> nocuadradosit = noCuadrados.iterator();
            while (nocuadradosit.hasNext()) {

            }
        }

    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}

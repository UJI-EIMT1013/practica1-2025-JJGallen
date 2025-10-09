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
            Set<Integer> recotemp = new HashSet<>();
            recorrer = listarecorrer.iterator();
            if (siguiente != 0) {
                if (!(recorrer.hasNext())) {
                    recotemp.add(siguiente);
                }
                else {
                    while (recorrer.hasNext()) {
                        Integer sigrec = recorrer.next();
                        if ((siguiente % sigrec) == 0) {
                            resultado.add(siguiente);
                        } else {
                            recotemp.add(siguiente);
                            if ((sigrec % siguiente) == 0) {
                                resultado.add(sigrec);
                            }
                        }
                    }
                }
                listarecorrer.addAll(recotemp);
            }
        }
        recorrer = listarecorrer.iterator();
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> listarecorrer = new HashSet<>();
        listarecorrer.addAll(cuadrados);
        listarecorrer.addAll(noCuadrados);
        Iterator<Integer> recorrerini = listarecorrer.iterator();
        if (recorrerini.hasNext()) {
            Set<Integer> cuadradosres = new HashSet<>();
            Set<Integer> noCuadradosres = new HashSet<>();
            Iterator<Integer> recorrerfin = listarecorrer.iterator();
            noCuadradosres.add(recorrerini.next());
            while (recorrerini.hasNext()) {
                Integer ini = recorrerini.next();
                Integer fin = recorrerfin.next();
                if (Math.sqrt(ini) == fin) {
                    cuadradosres.add(ini);
                }
                if (Math.sqrt(fin) == ini) {
                    cuadradosres.add(fin);
                }
                noCuadradosres.add(ini);
            }
            if (cuadrados.contains(1) && noCuadrados.contains(1)) {
                cuadradosres.add(1);
            }
            noCuadradosres.removeAll(cuadradosres);
            noCuadrados.clear();
            noCuadrados.addAll(noCuadradosres);
            cuadrados.clear();
            cuadrados.addAll(cuadradosres);
        }
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        Collection<Set<T>> resultado = new ArrayList<>();
        if (it.hasNext()) {
            Set<T> lista = new HashSet<>();
            Queue<T> cola = new ArrayDeque<>();
            while (it.hasNext()) {
                T itval = it.next();
                if (lista.contains(itval)) {
                    cola.add(itval);
                }
                else {
                    lista.add(itval);
                }
            }
            resultado.add(lista);
            lista = new HashSet<>();
            while (!(cola.isEmpty())) {
                T colval = cola.remove();
                if (lista.contains(colval)) {
                    cola.add(colval);
                }
                else {
                    lista.add(colval);
                }
                if (lista.containsAll(cola)) {
                    resultado.add(lista);
                    lista = new HashSet<>();
                }
            }
        }
        return resultado;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new HashSet<>();
        if (u.iterator().hasNext()) {
            ArrayList<Integer> colpos = new ArrayList<>();
            int[] colres = new int[2];
            for (int a = 0; a < col.size(); a++) {
                if ((u.containsAll(col.get(a))) && (!(u.equals(col.get(a))))) {
                    colpos.add(a);
                }
            }
            for (int a = 0; a < colpos.size(); a++) {
                for (int b = 0; b < colpos.size(); b++) {
                    Set<T> colunit = new HashSet<>();
                    colunit.addAll(col.get(colpos.get(a)));
                    colunit.addAll(col.get(colpos.get(b)));
                    if (u.equals(colunit)) {
                        resultado.add(col.get(colpos.get(a)));
                        resultado.add(col.get(colpos.get(b)));
                        return resultado;
                    }
                }
            }
        }
        return resultado;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countsort;

import java.util.Arrays;

/**
 *
 * @author Ykaro
 */
public class CountSort {

    public int[] countSort(int[] desordenado, int[] ordenado, int maiorElemento) {
        int[] somaElementos = new int[maiorElemento + 1];
        for (int i = 0; i <= maiorElemento; i++) {
            somaElementos[i] = 0;
        }
        for (int i = 0; i < desordenado.length; i++) {
            somaElementos[desordenado[i]] = somaElementos[desordenado[i]] + 1;
        }
        for (int i = 1; i <= maiorElemento; i++) {
            somaElementos[i] = somaElementos[i] + somaElementos[i - 1];
        }
        for (int i = desordenado.length - 1; i >= 0; i--) {
            ordenado[somaElementos[desordenado[i]] - 1] = desordenado[i];
            somaElementos[desordenado[i]] = somaElementos[desordenado[i]] - 1;
        }
        return ordenado;

    }

    public static void main(String[] args) {
        int vetDesordenado[] = {2, 5, 8, 10, 12, 15};
        int vetOrdenado[] = new int[vetDesordenado.length];
        System.out.println(Arrays.toString(new CountSort().countSort(vetDesordenado, vetOrdenado, 15)));
    }
}

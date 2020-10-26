/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio14;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static float determinante(float[][] A){
        int i;
        float det = 0.0f;
        if (A.length == 1)
            return A[0][0];
        for (i = 0; i < A.length; i ++){
            det += Math.pow(-1,1 + (i + 1)) * determinante(submatriz(A,i,0)) * A[0][i];
        }
        return det;
    }
    
    public static float[][] submatriz(float[][] A, int i, int j){
        int k, l;
        float sub[][] = new float [A.length - 1][A.length - 1];
        for (k = 0; k < A.length; k ++){
            for (l = 0; l < A.length; l ++){
                if (k != i || l != j){
                    if (k  < i && l < j)
                        sub[l][k] = A[l][k];
                    else if (k  > i && l < j)
                        sub[l][k - 1] = A[l][k];
                    else if (k < i && l > j)
                        sub[l - 1][k] = A[l][k];
                    else if (k > i && l > j)
                        sub[l - 1][k - 1] = A[l][k];
                }
            }
        }
        return sub;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        int i, j;
        System.out.println("Digite o tamanho da matriz: ");
        int tamanho = in.nextInt();
        float [][] matriz = new float [tamanho][tamanho];
        for (i = 0; i < tamanho; i ++){
            for (j = 0; j < tamanho; j ++){
                System.out.println("Digite o elemento de linha " + (i + 1) + " e coluna " + ( j + 1));
                matriz[i][j] = in.nextFloat();
            }
        }
        System.out.println("O determinante da matriz dada e: " + determinante(matriz));
    }
}

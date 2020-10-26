/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio10;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static double serie(int n){
        int i;
        double soma = 0;
        for (i = 0; i < n; i ++)
            soma += Math.pow(-1,i) / (2 * i + 1);
        return soma;
    }
    
    public static void main(String[] args){
        int n = 1; //para trocar o teste, mudar o valor de N 
        System.out.println("A soma dos " + n + " primeiros termos e: " + (4 * serie(n)));
        n = 2;
        System.out.println("A soma dos " + n + " primeiros termos e: " + (4 * serie(n)));
        n = 4;
        System.out.println("A soma dos " + n + " primeiros termos e: " + (4 * serie(n)));
        n = 6; 
        System.out.println("A soma dos " + n + " primeiros termos e: " + (4 * serie(n)));
    }
    
}

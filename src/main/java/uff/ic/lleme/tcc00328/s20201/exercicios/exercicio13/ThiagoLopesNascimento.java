/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio13;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static double media(int n){
        int i;
        double soma = 0;
        Scanner in = new Scanner(System.in);
        for (i = 0; i < n; i ++)
            soma += in.nextDouble();
        return (soma/n);
    }
    
    public static void main(String[] args){
        int n;
        double soma;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a quantidade de elementos para o calculo da media: ");
        n = in.nextInt();
        System.out.println("Digite os elementos para o calculo da media: ");
        soma = media(n);
        System.out.println("A media e: " + soma);
    }
    
}

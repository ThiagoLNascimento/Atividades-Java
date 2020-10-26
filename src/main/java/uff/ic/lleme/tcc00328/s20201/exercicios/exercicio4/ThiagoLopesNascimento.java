/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio4;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static void main (String[] args){
        
        Scanner in = new Scanner(System.in); //criando objeto para leitura do teclado
        System.out.println("Digite o numero para descobrir se e primo: ");
        int num = in.nextInt();
        int divisor = num - 1;
        boolean teste = false;
        if (num == 1)   teste = true; //garantir o caso do 1 sem causar problema na divisão
        else if (num == 2) teste = false; //exceção do 2 por ser par e primo ao mesmo tempo
        else if (num > 2){
            if (num % 2 != 0){
                do{
                    if (num % divisor == 0)     teste = true;
                    divisor --;
                }while(teste == false && divisor > 2);
            }
            else teste = true;
        }
        
        if (teste == true) System.out.println(num + " nao e primo");
        else System.out.println(num + " e primo");
        
    }
}

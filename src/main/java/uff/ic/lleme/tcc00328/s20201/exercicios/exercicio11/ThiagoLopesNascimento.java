/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio11;

/**
 *
 * @author Thiago
 */

public class ThiagoLopesNascimento {
    
    public static void main (String[] args){
        
        int num = 2;
        int divisor;
        long mult = 1;
        boolean teste;
        while(num < 50){
            divisor = num - 1;
            teste = false;
            if (num > 2){
                if (num % 2 != 0){
                    do{
                        if (num % divisor == 0 )    teste = true;
                        divisor --;
                    }while(teste == false && divisor > 2);
                }
                else teste = true;
            }
            if (teste == false){
                mult *= num;
            }
            num++;
        }
        System.out.println("A multiplicação dos primos entre 1 e 50 é: " + mult);
    }
}
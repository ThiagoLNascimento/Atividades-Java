/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio7;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static int mdc(int num1, int num2){
        int resto;
        for(resto = num1 % num2; resto != 0; resto = num1 % num2){
            num1 = num2;
            num2 = resto;
        }
        return num2;
    }
    
    public static void main(String[] args){
        int num1 = 42;
        int num2 = 24;
        if (num2 > num1){
            int troca = num2;
            num2 = num1;
            num1 = troca;
        }
        System.out.println("O mdc entre " + num1 + " e " + num2 + " é: " + mdc(num1, num2));
        num1 = 42; //Alterar os valores dessas duas variaves para mudar o MDC
        num2 = 23;
        if (num2 > num1){
            int troca = num2;
            num2 = num1;
            num1 = troca;
        }
        System.out.println("O mdc entre " + num1 + " e " + num2 + " é: " + mdc(num1, num2));
        num1 = 10; //Alterar os valores dessas duas variaves para mudar o MDC
        num2 = 10;
        if (num2 > num1){
            int troca = num2;
            num2 = num1;
            num1 = troca;
        }
        System.out.println("O mdc entre " + num1 + " e " + num2 + " é: " + mdc(num1, num2));
        
    }
    
}

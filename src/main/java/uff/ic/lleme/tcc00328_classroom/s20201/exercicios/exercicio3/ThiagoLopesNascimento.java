/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328_classroom.s20201.exercicios.exercicio3;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in); //criando objeto para leitura do teclado
        int num1, num2, resto;
        System.out.println("Digite o primeiro numero para calcular o MDC: ");
        num1 = in.nextInt();
        System.out.println("Digite o segundo numero para calcular o MDC: ");
        num2 = in.nextInt();
        
        if (num2 > num1){    //garantir que num1 seja maior do que num2 sempre
            int troca = num1;
            num1 = num2;
            num2 = troca;
        }
        
        do{
            resto = num1 % num2;
            num1 = num2;
            num2 = resto;
        }while(num1 % num2 != 0);
        
        System.out.println("O resultado do MDC é: " + num2);
    }
    
}

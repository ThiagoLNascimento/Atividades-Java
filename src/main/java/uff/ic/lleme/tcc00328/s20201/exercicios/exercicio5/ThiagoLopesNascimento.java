/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio5;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static int fibo(int num){
        
        if (num == 0)   return 0;
        if (num == 1)   return 1;
        return fibo(num - 1) + fibo(num - 2);

    }
    
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);//criando objeto para leitura do teclado
        System.out.println("Digite qual termo da lista de Fibonnaci deseja saber: ");
        int num = in.nextInt() - 1;
        int resp = fibo(num);
        System.out.print("O termo " + (num + 1));
        System.out.print(" é " + resp);
    }
    
}

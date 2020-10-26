/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio2;
/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static void main (String[] args){
        
        Scanner in = new Scanner (System.in); //variável para ler da tela
        System.out.println("Digite o número para calcular o fatorial: ");
        int num = in.nextInt();
        int fat = num;
        if (num > 1){
          do{
               fat *= --num;
            }while(num > 1);
        }
        System.out.println("O resultado do fatorial é: ");
        System.out.print(fat);
    }
}

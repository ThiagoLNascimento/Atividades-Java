/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio6;

/**
 *
 * @author Thiago
 */
import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static void main (String[] args){
        
        Scanner in = new Scanner(System.in); //criando objeto para leitura do teclado
        System.out.println("Digite o numero de termos da serie");
        int num = in.nextInt();
        int i = 0;
        
        double resp = 0;
        
        do{
            resp += Math.pow(-1,i) / (2 * i + 1);
            i++;
        }while(num  > i);
        
        System.out.println("A soma dos termos e: " + (4 * resp));
    } 
}

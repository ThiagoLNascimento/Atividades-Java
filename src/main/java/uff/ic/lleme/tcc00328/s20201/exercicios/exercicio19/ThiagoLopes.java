/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio19;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopes {
    
    
    public static void main(String[] args){
        int dado1, dado2;
        Scanner in = new Scanner (System.in);
        System.out.println("Digite o valor do primeiro dado: ");
        dado1 = in.nextInt();
        System.out.println("Digite o valor do segundo dado: ");
        dado2 = in.nextInt();
        int soma = dado1 + dado2;
        if(soma == 7 || soma == 11)
            System.out.println("O jogador venceu!!");
        else if(soma == 2 || soma == 3 || soma == 12)
            System.out.println("O jogador perdeu!!");
        else{
            int ponto = soma;
            System.out.println("O seu 'ponto' será " + soma + " tire o mesmo valor antes de 7 e ganhe o jogo.");
            while(true){
                System.out.println("Digite o valor do primeiro dado: ");
                dado1 = in.nextInt();
                System.out.println("Digite o valor do segundo dado: ");
                dado2 = in.nextInt();
                soma = dado1 + dado2;
                if (soma == ponto){
                    System.out.println("O jogador venceu!!");
                    break;
                }
                else if(soma == 7){
                    System.out.println("O jogador perdeu!!");
                    break;
                }
            }
        }
    }
}

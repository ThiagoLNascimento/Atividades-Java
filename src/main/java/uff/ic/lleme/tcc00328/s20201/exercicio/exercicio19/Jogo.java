/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio19;

import java.util.Scanner;

/**
 *
 * @author Thiago
 */
abstract class Jogo {
    
    public static void jogo(Mesa mesa){
        int dado1, dado2;
        Scanner in = new Scanner (System.in);
        System.out.println("Digite o valor do primeiro dado: ");
        dado1 = in.nextInt();
        System.out.println("Digite o valor do segundo dado: ");
        dado2 = in.nextInt();
        int soma = dado1 + dado2;
        if(mesa.getPonto() == -1){
            if(soma == 7 || soma == 11){
                System.out.println("O jogador venceu!!");
                mesa.finalizada = 1;
                return;
            }
            else if(soma == 2 || soma == 3 || soma == 12){
                System.out.println("O jogador perdeu!!");
                mesa.finalizada = 2;
                return;
            }
            else{
                System.out.println("O seu 'ponto' será " + soma + " tire o mesmo valor antes de 7 e ganhe o jogo.");
                mesa.setPonto(soma);
                return;
            }
        }
        if (soma == mesa.getPonto()){
            System.out.println("O jogador venceu!!");
            mesa.finalizada = 1;
            return;
        }
        else if(soma == 7){
            System.out.println("O jogador perdeu!!");
            mesa.finalizada = 2;
            return;
        }
        System.out.println("Resultado diferente do seu ponto e de 7, tente novamente.");
    }
}

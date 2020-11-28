/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio19;

/**
 *
 * @author Thiago
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThiagoLopes {
    
    public static Mesa mesa[] = new Mesa[100];
    
    public static int criarMesa(int quant_mesas){
        if (quant_mesas < 100){
            Scanner in = new Scanner (System.in);
            mesa[quant_mesas] = new Mesa();
            System.out.println("Digite o nome do jogador: ");
            mesa[quant_mesas].setNome(in.next());
            quant_mesas ++;
            System.out.println("Deseja começar a jogar com esta partida? Digite 1 para sim e outro valor para voltar ao menu.");
            int i = in.nextInt();
            if(i == 1){
                Jogo.jogo(mesa[quant_mesas - 1]);
                while(mesa[quant_mesas - 1].finalizada == 0){
                    System.out.println("Deseja continuar o jogo? Digite 1 para continuar e outro valor para voltar ao menu.");
                    int num = in.nextInt();
                    if(num == 1)
                        Jogo.jogo(mesa[quant_mesas - 1]);
                    else if(num != 1)
                        return quant_mesas;
                    }
            }
            return quant_mesas;
        }
        return quant_mesas;
    }
    
    public static void verMesa(int quant_mesas){
        Scanner in = new Scanner (System.in);
        System.out.println("Diga o nome do jogador ou o numero da mesa: ");
        try{
            int num = in.nextInt();
            System.out.println("\nSituacao da mesa: " + num);
            mesa[num - 1].situacao();
        }catch(InputMismatchException | ArrayIndexOutOfBoundsException a){
            String name = in.next();
            for(int i = 0; i < quant_mesas; i ++){
                if(mesa[i].getNome().equals(name)){
                    System.out.println("\nSituacao da mesa: " + (i + 1));
                    mesa[i].situacao();
                    return;
                }
            }
            System.out.println("\nMesa nao encontrada");
        }
    }
    
    public static void partida(int quant_mesas){
        Scanner in = new Scanner (System.in);
        System.out.println("Diga o nome do jogador ou o numero da mesa: ");
        try{
            int num = in.nextInt();
            Jogo.jogo(mesa[num - 1]);
        }catch(InputMismatchException | ArrayIndexOutOfBoundsException a){
            String name = in.next();
            for(int i = 0; i < quant_mesas; i ++){
                if(mesa[i].getNome().equals(name)){
                    if(mesa[i].finalizada == 1){
                        System.out.println("Jogo finalizado, jogador venceu!");
                        return;
                    }
                    else if(mesa[i].finalizada == 2){
                        System.out.println("Jogo finalizad, jogador perdeu!");
                        return;
                    }
                    Jogo.jogo(mesa[i]);
                    while(mesa[i].finalizada == 0){
                        System.out.println("Deseja continuar o jogo? Digite 1 para continuar e outro valor para voltar ao menu.");
                        int num = in.nextInt();
                        if(num == 1)
                            Jogo.jogo(mesa[i]);
                        else if(num != 1)
                            return;
                    }
                    return;
                }
            }
            System.out.println("\nMesa nao encontrada");
        }
    }
    
    
    public static void main(String[] args){
        
        int quant_mesas = 0, op;
        Scanner in = new Scanner (System.in);
        
        while(true){
            
            System.out.println("\nDigite 1 para adicionar uma mesa/jogo.");
            System.out.println("Digite 2 para ver a situação de uma mesa.");
            System.out.println("Digite 3 para escolher uma mesa para jogar.");
            
            op = in.nextInt();
            System.out.println("");
            if(op == 1)
                quant_mesas = criarMesa(quant_mesas);
            if(op == 2)
                verMesa(quant_mesas);
            if(op == 3)
                partida(quant_mesas);
            
        }
    }
}
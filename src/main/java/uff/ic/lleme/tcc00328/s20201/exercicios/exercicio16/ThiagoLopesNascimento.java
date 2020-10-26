/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio16;

/**
 *
 * @author Thiago
 */

import java.util.Scanner;

public class ThiagoLopesNascimento {
    
    public static int campeonato(int[][] tabela, int times){
        int i, j, maior, emp = 0;
        int [] primeiro = new int [times];
        int [] copia = new int [times];
        maior = -100;
        for (j = 0; j < times; j ++){
                if (maior < tabela[j][0]){
                    emp = 0;
                    maior = tabela[j][0];
                    primeiro[0] = j + 1;
                }
                else if (maior == tabela[j][0]){
                    emp ++;
                    primeiro[emp] = j + 1;
                }
        }
        for (i = 0; i < 5; i ++){
            maior = -100;
            emp = 0;
            copia[0] = primeiro[0];
            j = 0;
            while (primeiro[j] != 0){
                if (maior < tabela[primeiro[j] - 1][i]){
                    emp = 0;
                    maior = tabela[primeiro[j] - 1][i];
                    copia[0] = primeiro[j];
                }
                else if (maior == tabela[primeiro[j] - 1][i]){
                    emp ++;
                    copia[emp] = primeiro[j];
                }
                j++;
                if (j == times)
                    break;
            }
            
            for(j = 0; j < copia.length; j++){
                primeiro[j] = copia[j];
            }
        }
        return primeiro[0];
    }
    
    public static void main(String[] args){
        
        Scanner in = new Scanner (System.in);
        int i, j;
        int times = 3; //Quantidade de times no campeonato
        int [][] tabela = new int[times][5];
        for (i = 0; i < times; i ++){
            for (j = 0; j < 5; j ++)
                tabela[i][j] = in.nextInt();
       }
        System.out.println("O lider do campeonato e: " + campeonato(tabela, times));
    }
}

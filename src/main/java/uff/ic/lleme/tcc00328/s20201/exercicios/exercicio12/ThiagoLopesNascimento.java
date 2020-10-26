/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio12;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static int[] div(int n, int [] vet){
        int i, quant = 0;
        for (i = 1; i <= n; i ++){
            if (n % i == 0){
                vet[quant] = i;
                quant ++;
            }
        }
        return vet;
    }
    
    public static void main(String[] args){
        int n = 1, quant = 0, vet[];
        vet = new int[n];
        vet = div(n,vet);
        System.out.println("Os divisores de " + n + " sao:");
        while(vet[quant] != 0){
            System.out.print(vet[quant] + " ");
            quant++;
            if (quant == n)
                break;
        }
        n = 2;   //Para testar um valor diferente somente trocar o valor de N 
        quant = 0;
        vet = new int[n];
        vet = div(n,vet);
        System.out.println("\nOs divisores de " + n + " sao:");
        while(vet[quant] != 0){
            System.out.print(vet[quant] + " ");
            quant++;
            if (quant == n)
                break;
        }
        n = 7;
        quant = 0;
        vet = new int[n];
        vet = div(n,vet);
        System.out.println("\nOs divisores de " + n + " sao:");
        while(vet[quant] != 0){
            System.out.print(vet[quant] + " ");
            quant++;
            if (quant == n)
                break;
        }
        n = 10;
        quant = 0;
        vet = new int[n];
        vet = div(n,vet);
        System.out.println("\nOs divisores de " + n + " sao:");
        while(vet[quant] != 0){
            System.out.print(vet[quant] + " ");
            quant++;
            if (quant == n)
                break;
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio9;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static int fibo(int n){
        int ant1 = 1, ant2 = 0,resp = 0,i;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        for(i = 0; i < n - 1; i ++){
            resp = ant1 + ant2;
            ant2 = ant1;
            ant1 = resp;
        }
        return resp;
    }
    
    public static void main(String[] args){
        int n = 0; // Para mudar o termo, mudar o valor de N
        System.out.println("O termo " + (n+1) + " e " + fibo(n));
        n = 1;
        System.out.println("O termo " + (n+1) + " e " + fibo(n));
        n = 2;
        System.out.println("O termo " + (n+1) + " e " + fibo(n));
        n = 6;
        System.out.println("O termo " + (n+1) + " e " + fibo(n));
        n = 8;
        System.out.println("O termo " + (n+1) + " e " + fibo(n));
    }
    
}

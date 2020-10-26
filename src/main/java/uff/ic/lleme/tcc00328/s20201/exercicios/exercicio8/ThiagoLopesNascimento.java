/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio8;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static int primo(int n){
        int i;
        if (n == 1) 
            return 0;
        if (n == 2)
            return 1;
        for (i = 2; i < n;i ++){
            if (n % i == 0)
                return 0; 
            }
        return 1;
    }
    
    public static void main(String[] args){
        int n = 1, teste;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        n = 2;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        n = 5;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        n = 9;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        n = 11;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        n = 15;
        teste = primo(n);
        if (teste == 0)
            System.out.println(n + " nao e primo");
        else
            System.out.println(n + " e primo");
        
    }
}

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
public class Mesa {
    
    private int ponto = - 1;
    private String nome = null;
    public int finalizada = 0; //0 jogo em andamento, 1 jogo vencido, 2 jogo perdido
    
    public void setNome(String arg){
        this.nome = arg;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setPonto(int arg){
        this.ponto = arg;
    }
    
    public int getPonto(){
        return this.ponto;
    }
    
    public void situacao(){
        System.out.println("Nome do jogador: " + this.nome);
        System.out.println("Ponto da mesa: " + this.ponto);
        if(this.finalizada == 0)
            System.out.println("Jogo ainda em andamento.");
        else if(this.finalizada == 1)
            System.out.println("Jogo terminado, jogador venceu!");
        else if(this.finalizada == 2)
            System.out.println("JOgo terminado, jogador perdeu!");
    }
}

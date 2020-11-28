/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio22;

/**
 *
 * @author Thiago
 */
public class Jurado {
    
    private String nome = null;
    private Nota[][] nota = new Nota[4][10];
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String arg){
        this.nome = arg;
    }
    
    public Nota getNota(int x, int y){
        return nota[x][y]; 
    }
    
    public void setNota(Nota arg, int x, int y){
        this.nota[x][y] = arg;
    }
    
    public Jurado(){
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 10; j ++){
                this.nota[i][j] = new Nota();
            }
        }
        
    }
    
}

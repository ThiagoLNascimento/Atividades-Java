/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio23.exercicio23a;

/**
 *
 * @author Thiago
 */
public class Item {
    
    private int quantidade;
    private Produto produto;
    
    public Item(){
        
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
}

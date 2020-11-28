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
public class Carrinho {
    
    private Item[] item = new Item[100];
    
    public Carrinho(){
        
    }
    
    public Item[] getItens(){
        return this.item;
    }
    
    public void setItem(Item[] item){
        this.item = item;
    }
}

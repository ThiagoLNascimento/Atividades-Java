/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328_classroom.s20201.provas.p1.ThiagoLopes;

/**
 *
 * @author Thiago
 */

import java.util.NoSuchElementException;;
public class pedido {
    
    public item[] item = new item[5];
    
    public float valorConta(){
        
        float conta = 0.0f;
        for (int i = 0; i < 5; i ++){
            try{
                conta += this.item[i].prato.preco * this.item[i].quant;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                break;
            }
        }
    return conta;  
    }
}

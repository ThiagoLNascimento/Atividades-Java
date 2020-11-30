/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.prova.p2.ThiagoLopes;

/**
 *
 * @author Thiago
 */

import java.util.ArrayList;

public class Dicionario {

    
    public  ArrayList <Palavra> palavras = new ArrayList<Palavra>();

    Dicionario(){
        
    }
    
    public  void adicionar(String grafia){
        
        Palavra palavra = new Palavra(grafia, null);
        palavras.add(palavra);
        
    }
    
    public  void listar(){
        
        for(int i = 0; i < palavras.size(); i ++){
            palavras.get(i).listar();
        }
            
    }
    
}

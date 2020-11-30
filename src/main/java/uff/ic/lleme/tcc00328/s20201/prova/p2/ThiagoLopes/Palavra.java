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

public class Palavra {
    
    public String fonetica;
    public String grafia;
    public ArrayList <Sinonimos> sinonimo = new ArrayList<Sinonimos>();
    
    Palavra(String grafia, String fonetica){
        
        this.fonetica = fonetica;
        this.grafia = grafia;
        
    }
    
    Palavra(){
        
        this.fonetica = null;
        this.grafia = null;
        
    }
    
    public void adicionarSignificado(String significado){
        
        Sinonimos sinonimo_aux = new Sinonimos(significado);
        sinonimo_aux.palavras.add(this);
        sinonimo.add(sinonimo_aux);
        
    }
        
    public void adicionarSignificado(Sinonimos sinonimos){

        sinonimos.palavras.add(this);
        sinonimo.add(sinonimos);
        
    }
    
    public void listar(){
        
        System.out.println(grafia);
        for(int i = 0; i < sinonimo.size(); i ++){
            System.out.println("\tsignificado " + i + ": " + sinonimo.get(i).significado);
        }
        
    }
    
    
}
